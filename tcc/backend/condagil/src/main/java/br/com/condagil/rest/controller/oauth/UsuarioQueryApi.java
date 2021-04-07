package br.com.condagil.rest.controller.oauth;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.condagil.config.oauth.CurrentUser;
import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.models.dto.oauth.UsuarioLocalDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface UsuarioQueryApi {

	@Operation(summary = "Recuperar os usuários do sistema")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de usuários recuperados com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) })
	})
	@GetMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuarioDTO> getItensUsuario();
	
	@Operation(summary = "Recupera o usuário pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Usuário recuperado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) })
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable(value = "id") Long usuarioId) throws ResourceNotFoundException;
	
    @GetMapping("/me")
    //@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getCurrentUser(@CurrentUser UsuarioLocalDTO user);
}