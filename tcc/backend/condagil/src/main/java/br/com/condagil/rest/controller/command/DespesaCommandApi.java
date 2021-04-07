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

import br.com.condagil.models.dto.DespesaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface DespesaCommandApi {

	@Operation(summary = "Criar uma nova despesa para o condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Despesa criada com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = DespesaDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public DespesaDTO novaDespesa(@Parameter(description="Despesa") @RequestBody DespesaDTO despesaDTO);
	
	@Operation(summary = "Deletar uma despesa de um usuário pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarDespesa(@PathVariable Long id);
	
	@Operation(summary = "Atualizar os dados de uma despesa do condomínio pelo id")
	@PutMapping(path = "/{id}")
	public DespesaDTO atualizarDespesa(@RequestBody DespesaDTO despesaDTO, @PathVariable Long id);
	
}
