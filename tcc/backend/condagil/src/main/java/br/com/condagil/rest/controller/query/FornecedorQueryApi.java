package br.com.condagil.rest.controller.query;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.FornecedorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface FornecedorQueryApi {

	@Operation(summary = "Recuperar os Fornecedores de um condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de Fornecedores recuperados com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorDTO.class)) })
	})
	@GetMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FornecedorDTO> getItensFornecedor();
	
	@Operation(summary = "Recupera o Fornecedor pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Fornecedor recuperado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorDTO.class)) })
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FornecedorDTO> getFornecedor(@PathVariable(value = "id") Long fornecedorId) throws ResourceNotFoundException;
	
}
