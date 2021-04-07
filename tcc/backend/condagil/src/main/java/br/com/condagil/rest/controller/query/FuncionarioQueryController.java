package br.com.condagil.rest.controller.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.FuncionarioDTO;
import br.com.condagil.service.query.FuncionarioQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "funcionario-query", description = "Funcionário query API")
public class FuncionarioQueryController implements FuncionarioQueryApi{

	@Autowired
	private FuncionarioQueryService funcionarioQueryService;

	public List<FuncionarioDTO> getItensFuncionario(){
		return funcionarioQueryService.recuperarFuncionarios();
	}
	
	public ResponseEntity<FuncionarioDTO> getFuncionario(@PathVariable(value = "id") Long funcionarioId) throws ResourceNotFoundException{
		FuncionarioDTO funcionarioDTO = funcionarioQueryService.recuperarFuncionarioPorId(funcionarioId);
		if(funcionarioDTO==null) {
			throw new ResourceNotFoundException("Funcionário não encontrado com o id :: " + funcionarioId);
		}
		return ResponseEntity.ok().body(funcionarioDTO);
	}
	
}