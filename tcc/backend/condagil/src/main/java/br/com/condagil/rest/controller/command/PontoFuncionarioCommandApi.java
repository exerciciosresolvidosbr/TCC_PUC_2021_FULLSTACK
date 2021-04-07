package br.com.condagil.rest.controller.command;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.condagil.models.dto.PontoFuncionarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface PontoFuncionarioCommandApi {

	@Operation(summary = "Criar um novo registro de ponto para o Funcionário de um condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Novo registro de ponto criado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PontoFuncionarioDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public PontoFuncionarioDTO novoPontoFuncionario(@Parameter(description="PontoFuncionario") @RequestBody PontoFuncionarioDTO pontoFuncionarioDTO);
	
	@Operation(summary = "Deletar um ponto de um funcionário pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarPontoFuncionario(@PathVariable Long id);
}
