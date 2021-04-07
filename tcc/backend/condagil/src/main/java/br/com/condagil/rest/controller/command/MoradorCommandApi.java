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

import br.com.condagil.models.dto.MoradorDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MoradorCommandApi {

	@Operation(summary = "Criar um nov Morador para o condomínio")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Morador criado com sucesso", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = MoradorDTO.class)) })
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) @ResponseStatus(code = HttpStatus.CREATED)
	public MoradorDTO novoMorador(@Parameter(description="morador") @RequestBody MoradorDTO moradorDTO);
	
	@Operation(summary = "Deletar um Morador pelo id")
	@DeleteMapping(path = "/{id}")
	public Map<String, Boolean> deletarMorador(@PathVariable Long id);
	
	@Operation(summary = "Atualizar os dados de um Morador do condomínio pelo id")
	@PutMapping(path = "/{id}")
	public MoradorDTO atualizarMorador(@RequestBody MoradorDTO moradorDTO, @PathVariable Long id);
	
}
