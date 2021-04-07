package br.com.condagil.rest.controller.query;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.MoradorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MoradorQueryApi {

	@Operation(summary = "Recuperar os Moradores de um condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de Moradores recuperados com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MoradorDTO.class)) })
	})
	@GetMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MoradorDTO> getItensMorador();
	
	@Operation(summary = "Recupera o Morador pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Morador recuperado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MoradorDTO.class)) })
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MoradorDTO> getMorador(@PathVariable(value = "id") Long moradorId) throws ResourceNotFoundException;
	
}
