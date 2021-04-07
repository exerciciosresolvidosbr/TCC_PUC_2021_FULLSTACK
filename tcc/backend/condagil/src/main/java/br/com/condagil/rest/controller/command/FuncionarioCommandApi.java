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

import br.com.condagil.models.dto.FuncionarioDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface FuncionarioCommandApi {

	@Operation(summary = "Criar um novo registro para o Funcionário para o condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Funcionário criado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FuncionarioDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public FuncionarioDTO novoFuncionario(@Parameter(description="Funcionario") @RequestBody FuncionarioDTO funcionarioDTO);
	
	@Operation(summary = "Deletar um Funcionário pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarFuncionario(@PathVariable Long id);
	
	@Operation(summary = "Atualizar os dados de um Funcionário do condomínio pelo id")
	@PutMapping(path = "/{id}")
	public FuncionarioDTO atualizarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long id);
	
}
