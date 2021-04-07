package br.com.condagil.rest.controller.command;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.condagil.models.dto.ComunicadoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ComunicadoCommandApi {

	@Operation(summary = "Criar um novo Comunicado para o condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Comunicado criado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ComunicadoDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public ComunicadoDTO novoComunicado(@Parameter(description="Comunicado") @RequestBody ComunicadoDTO ComunicadoDTO);
	
	@Operation(summary = "Deletar um Comunicado pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarComunicado(@PathVariable Long id);
	
	@Operation(summary = "Atualizar os dados de um Comunicado do condomínio pelo id")
	@PutMapping(path = "/{id}")
	public ComunicadoDTO atualizarComunicado(@RequestBody ComunicadoDTO ComunicadoDTO, @PathVariable Long id);
}
