package br.com.condagil.rest.controller.query;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.ComunicadoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ComunicadoQueryApi {

	@Operation(summary = "Recuperar os Comunicados de um condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de Comunicados recuperados com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ComunicadoDTO.class)) })
	})
	@GetMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ComunicadoDTO> getItensComunicado();
	
	@Operation(summary = "Recupera o Comunicado pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Comunicado recuperado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ComunicadoDTO.class)) })
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ComunicadoDTO> getComunicado(@PathVariable(value = "id") Long comunicadoId) throws ResourceNotFoundException;
	
	@Operation(summary = "Exportar o Comunicado pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Comunicado em PDF gerado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = InputStreamResource.class)) })
	})
	@GetMapping(value = "/export/pdf/{id}")
	public ResponseEntity<InputStreamResource> exportarComunicadoPdf(@PathVariable(value = "id") Long comunicadoId) throws ResourceNotFoundException;
}