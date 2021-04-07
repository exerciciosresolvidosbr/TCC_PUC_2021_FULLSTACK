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

import br.com.condagil.models.dto.FornecedorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface FornecedorCommandApi {

	@Operation(summary = "Criar um novo Fornecedor para o condomínio")
	@ApiResponses(value = { 
		@ApiResponse(responseCode = "200", description = "Fornecedor criado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = FornecedorDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public FornecedorDTO novoFornecedor(@Parameter(description="Fornecedor") @RequestBody FornecedorDTO fornecedorDTO);
	
	@Operation(summary = "Deletar um Fornecedor pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarFornecedor(@PathVariable Long id);
	
	@Operation(summary = "Atualizar os dados de um Fornecedor do condomínio pelo id")
	@PutMapping(path = "/{id}")
	public FornecedorDTO atualizarFornecedor(@RequestBody FornecedorDTO fornecedorDTO, @PathVariable Long id);
	
}
