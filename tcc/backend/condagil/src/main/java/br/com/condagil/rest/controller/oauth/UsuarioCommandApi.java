package br.com.condagil.rest.controller.oauth;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.condagil.models.dto.oauth.UsuarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface UsuarioCommandApi {

	@Operation(summary = "Criar um novo usuário para o sistema")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Usuário criado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioDTO novoUsuario(@Parameter(description="Usuario") @RequestBody UsuarioDTO usuarioDTO);
	
	@Operation(summary = "Deletar um usuário pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarUsurio(@PathVariable Long id);
	
	@Operation(summary = "Atualizar os dados de um usuário pelo id")
	@PutMapping(path = "/{id}")
	public UsuarioDTO atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id);
	
}
