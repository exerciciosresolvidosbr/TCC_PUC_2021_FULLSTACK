package br.com.condagil.models.builder.oauth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.condagil.models.dto.oauth.SignUpRequest;
import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.models.entity.oauth.Role;
import br.com.condagil.models.entity.oauth.Usuario;

public class UsuarioDTOBuilder {

	private UsuarioDTO usuarioDTO;

	private UsuarioDTOBuilder() {
		super();
		this.usuarioDTO = new UsuarioDTO();
	}
	
	public static UsuarioDTOBuilder getInstance() {
		return new UsuarioDTOBuilder();
	}
	
	public UsuarioDTOBuilder converterSignUpRequestEmUsuarioDTO(SignUpRequest signUpRequest, Role roleUser) {
		usuarioDTO.setProviderUserId(signUpRequest.getProviderUserId());
		usuarioDTO.setEnabled(Boolean.TRUE);
		usuarioDTO.setDisplayName(signUpRequest.getDisplayName());
		usuarioDTO.setEmail(signUpRequest.getEmail());
		usuarioDTO.setPassword(signUpRequest.getPassword());
		usuarioDTO.setProvider(signUpRequest.getSocialProvider().getProviderType());
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleUser);
		usuarioDTO.setRolesDTO(RoleDTOBuilder.converterListaEntityEmRoleDTO(roles));
		return this;
	}
	
	public UsuarioDTOBuilder converterEntityEmUsuarioDTO(Usuario entity) {
		usuarioDTO.setId(entity.getId());
		usuarioDTO.setProviderUserId(entity.getProviderUserId());
		usuarioDTO.setEmail(entity.getEmail());
		usuarioDTO.setEnabled(entity.getEnabled());
		usuarioDTO.setDisplayName(entity.getDisplayName());
		//usuarioDTO.setCreatedDate();
		//usuarioDTO.setModifiedDate();
		usuarioDTO.setPassword(entity.getPassword());
		usuarioDTO.setProvider(entity.getProvider());
		if(entity.getRoles()!=null) {
			usuarioDTO.setRolesDTO(RoleDTOBuilder.converterListaEntityEmRoleDTO(entity.getRoles()));
		}
		return this;
	}
	
	public static List<UsuarioDTO> converterListaEntityEmUsuarioDTO(List<Usuario> listaEntity) {
		List<UsuarioDTO> listaUsuariosDTO = new ArrayList<UsuarioDTO>();
		listaEntity.forEach(entity->{
			listaUsuariosDTO.add(
				UsuarioDTOBuilder.getInstance()
					.converterEntityEmUsuarioDTO(entity)
					.getUsuarioDTO()
			);
		});
		return listaUsuariosDTO;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}
}