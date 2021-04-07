package br.com.condagil.rest.controller.query;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.MultaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MultaQueryApi {

	@Operation(summary = "Recuperar as Multas de um condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de Multas recuperados com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MultaDTO.class)) })
	})
	@GetMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MultaDTO> getItensMulta();
	
	@Operation(summary = "Recupera a Multa pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Multa recuperada com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MultaDTO.class)) })
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MultaDTO> getMulta(@PathVariable(value = "id") Long multaId) throws ResourceNotFoundException;
	
	@Operation(summary = "Exportar a Multa pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Multa em PDF gerada com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = InputStreamResource.class)) })
	})
	@GetMapping(value = "/export/pdf/{id}")
	public ResponseEntity<InputStreamResource> exportarMultaPdf(@PathVariable(value = "id") Long multaId) throws ResourceNotFoundException;

}