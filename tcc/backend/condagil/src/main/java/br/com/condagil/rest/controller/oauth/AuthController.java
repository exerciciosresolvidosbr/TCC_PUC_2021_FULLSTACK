package br.com.condagil.rest.controller.oauth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condagil.exception.ApiErrors;
import br.com.condagil.exception.UsuarioJaExisteAutenticacaoException;
import br.com.condagil.models.builder.oauth.UsuarioDTOBuilder;
import br.com.condagil.models.dto.oauth.JwtAuthenticationResponse;
import br.com.condagil.models.dto.oauth.SignUpRequest;
import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.models.dto.oauth.UsuarioLocalDTO;
import br.com.condagil.models.entity.oauth.Role;
import br.com.condagil.repository.query.RoleQueryRepository;
import br.com.condagil.service.oauth.TokenProviderService;
import br.com.condagil.service.oauth.UsuarioCommandService;

@RestController
@RequestMapping("/api/oauth")
@CrossOrigin
public class AuthController implements AuthApi{

	@Autowired
    private AuthenticationManager authenticationManager;
 
    @Autowired
    private TokenProviderService tokenProviderService;
    
    @Autowired
    private UsuarioCommandService usuarioCommandService;
    
	@Autowired
	private RoleQueryRepository roleQueryRepository;
 
    @Override
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioDTO.getEmail(), usuarioDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProviderService.createToken(authentication);
        UsuarioLocalDTO usuarioLocalDTO = (UsuarioLocalDTO) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, usuarioLocalDTO.getUsuarioDTO()));
    }
    
    @Override
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        try {
        	usuarioCommandService.salvarUsuario(
        		UsuarioDTOBuilder
    				.getInstance()
    				.converterSignUpRequestEmUsuarioDTO(signUpRequest, roleQueryRepository.recuperarPorNome(Role.MORADOR))
    				.getUsuarioDTO()
        	);
        } catch (UsuarioJaExisteAutenticacaoException e) {
            return new ResponseEntity<>(new ApiErrors("Endereço de e-mail já está em uso!"), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body("Usuário registrado com successo");
    }
	
}
