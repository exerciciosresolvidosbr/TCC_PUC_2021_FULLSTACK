package br.com.condagil.rest.controller.query;

import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.DespesaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface DespesaQueryApi {

	@Operation(summary = "Recuperar as despesas de um condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Lista de despesas recuperadas com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DespesaDTO.class)) })
	})
	@GetMapping(value = "/itens", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DespesaDTO> getItensDespesa();
	
	@Operation(summary = "Recupera a despesa pelo id")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Despesa recuperada com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DespesaDTO.class)) })
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DespesaDTO> getDespesa(@PathVariable(value = "id") Long despesaId) throws ResourceNotFoundException;
	
	@Operation(summary = "Exportar em PDF a lista de despesas")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "PDF gerado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = InputStreamResource.class)) })
	})
	@GetMapping(value = "/export/pdf")
	public ResponseEntity<InputStreamResource> exportarDespesasPdf();
	
}
