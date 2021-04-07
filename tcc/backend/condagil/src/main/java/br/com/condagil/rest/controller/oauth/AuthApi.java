package br.com.condagil.rest.controller.oauth;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.condagil.models.dto.oauth.SignUpRequest;
import br.com.condagil.models.dto.oauth.UsuarioDTO;

public interface AuthApi {
	
	@PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UsuarioDTO usuarioDTO);
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest);
	
}
