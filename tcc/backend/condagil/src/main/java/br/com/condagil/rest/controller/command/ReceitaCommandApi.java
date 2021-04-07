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

import br.com.condagil.models.dto.ReceitaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface ReceitaCommandApi {

	@Operation(summary = "Criar uma nova receita para o condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Receita criada com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ReceitaDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public ReceitaDTO novaReceita(@Parameter(description="Receita") @RequestBody ReceitaDTO receitaDTO);
	
	@Operation(summary = "Deletar uma receita de um usuário pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarReceita(@PathVariable Long id);
	
	@Operation(summary = "Atualizar os dados de uma receita do condomínio pelo id")
	@PutMapping(path = "/{id}")
	public ReceitaDTO atualizarReceita(@RequestBody ReceitaDTO receitaDTO, @PathVariable Long id);
	
}
