package br.com.condagil.service.oauth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import br.com.condagil.exception.OAuth2AuthenticationProcessingException;
import br.com.condagil.exception.UsuarioJaExisteAutenticacaoException;
import br.com.condagil.models.builder.oauth.UsuarioBuilder;
import br.com.condagil.models.builder.oauth.UsuarioDTOBuilder;
import br.com.condagil.models.dto.oauth.OAuth2UserInfo;
import br.com.condagil.models.dto.oauth.SignUpRequest;
import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.models.dto.oauth.UsuarioLocalDTO;
import br.com.condagil.models.entity.oauth.Role;
import br.com.condagil.models.entity.oauth.Usuario;
import br.com.condagil.models.enums.SocialProvider;
import br.com.condagil.models.factory.OAuth2UserInfoFactory;
import br.com.condagil.repository.command.UsuarioCommandRepository;
import br.com.condagil.repository.query.RoleQueryRepository;

@Service
public class UsuarioCommandService {

	@Autowired
	private UsuarioCommandRepository usuarioCommandRepository;
	
	@Autowired
	private RoleQueryRepository roleQueryRepository;
	
    @Autowired
    private PasswordEncoder passwordEncoder;
	
	public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
		Boolean existsIdUsuario = usuarioDTO.getId()!=null && usuarioCommandRepository.recuperarUsuarioPorId(usuarioDTO.getId())!=null;
		Boolean existsEmailUsuario = usuarioCommandRepository.isEmailCadastrado(usuarioDTO.getEmail());
		if(existsIdUsuario || existsEmailUsuario) {
			throw new UsuarioJaExisteAutenticacaoException("Este usuário já está cadastrado, tente outro.");
		}
		Role role = roleQueryRepository.recuperarPorNome(
				usuarioDTO.getRolesDTO().stream()
				.findFirst().get()
				.getName()
		);
		Usuario entity = usuarioCommandRepository.salvarUsuario(
			UsuarioBuilder.getInstance()
				.converterDTOEmUsuario(usuarioDTO, passwordEncoder.encode(usuarioDTO.getPassword()), role)
				.addDataCorrenteCreatedDate()
				.addDataCorrenteModifiedDate()
				.idNull()
				.getUsuario()
		);
		return UsuarioDTOBuilder.getInstance()
				.converterEntityEmUsuarioDTO(entity)
				.getUsuarioDTO();
	}
	
	public void deletarUsuario(Long id) {
		usuarioCommandRepository.deletarUsuario(id);
	}
	
	public UsuarioDTO atualizarUsuario(UsuarioDTO usuarioDTO, Long id) {
		Usuario usuario = usuarioCommandRepository.recuperarUsuarioPorId(id);
		Role role = roleQueryRepository.recuperarPorNome(
				usuarioDTO.getRolesDTO().stream()
				.findFirst().get()
				.getName()
		);
		usuario = UsuarioBuilder.getInstance()
			.replaceUsuario(usuario)
			.converterDTOEmUsuario(usuarioDTO, passwordEncoder.encode(usuarioDTO.getPassword()), role)
			.getUsuario();
		return UsuarioDTOBuilder.getInstance()
				.converterEntityEmUsuarioDTO(usuarioCommandRepository.atualizarUsuario(usuario))
				.getUsuarioDTO();
	}
	
    @Transactional
    public UsuarioLocalDTO processUserRegistration(String registrationId, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(registrationId, attributes);
        if (ObjectUtils.isEmpty(oAuth2UserInfo.getName())) {
            throw new OAuth2AuthenticationProcessingException("Name not found from OAuth2 provider");
        } else if (ObjectUtils.isEmpty(oAuth2UserInfo.getEmail())) {
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }
        SignUpRequest userDetails = toUserRegistrationObject(registrationId, oAuth2UserInfo);
        UsuarioDTO usuarioDTO = UsuarioDTOBuilder.getInstance()
				.converterEntityEmUsuarioDTO(usuarioCommandRepository.recuperarPorEmail(oAuth2UserInfo.getEmail()))
				.getUsuarioDTO();
        if (usuarioDTO != null) {
            if (!usuarioDTO.getProvider().equals(registrationId) && !usuarioDTO.getProvider().equals(SocialProvider.LOCAL.getProviderType())) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " + usuarioDTO.getProvider() + " account. Please use your " + usuarioDTO.getProvider() + " account to login.");
            }
            usuarioDTO.setDisplayName(oAuth2UserInfo.getName());
            usuarioDTO = atualizarUsuario(usuarioDTO, usuarioDTO.getId());
        } else {
        	usuarioDTO = salvarUsuario(
    			UsuarioDTOBuilder
    				.getInstance()
    				.converterSignUpRequestEmUsuarioDTO(userDetails, roleQueryRepository.recuperarPorNome(Role.MORADOR))
    				.getUsuarioDTO()
        	);
        }
        return UsuarioLocalDTO.create(usuarioDTO, attributes, idToken, userInfo);
    }
    
    private SignUpRequest toUserRegistrationObject(String registrationId, OAuth2UserInfo oAuth2UserInfo) {
        return SignUpRequest.getBuilder().addProviderUserID(oAuth2UserInfo.getId()).addDisplayName(oAuth2UserInfo.getName()).addEmail(oAuth2UserInfo.getEmail())
                .addSocialProvider(toSocialProvider(registrationId)).addPassword("changeit").build();
    }
    
    public static SocialProvider toSocialProvider(String providerId) {
        for (SocialProvider socialProvider : SocialProvider.values()) {
            if (socialProvider.getProviderType().equals(providerId)) {
                return socialProvider;
            }
        }
        return SocialProvider.LOCAL;
    }
}