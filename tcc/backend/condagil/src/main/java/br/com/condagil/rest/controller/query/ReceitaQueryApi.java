package br.com.condagil.rest.controller.query;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.ReceitaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ReceitaQueryApi {

	@Operation(summary = "Recuperar as receitas de um condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de receitas recuperadas com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ReceitaDTO.class)) })
	})
	@GetMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReceitaDTO> getItensReceita();
	
	@Operation(summary = "Recupera a receita pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Receita recuperada com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ReceitaDTO.class)) })
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReceitaDTO> getReceita(@PathVariable(value = "id") Long receitaId) throws ResourceNotFoundException;
	
	@Operation(summary = "Exportar em PDF a lista de receitas")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "PDF gerado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = InputStreamResource.class)) })
	})
	@GetMapping(value = "/export/pdf")
	public ResponseEntity<InputStreamResource> exportarReceitasPdf();
}