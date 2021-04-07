package br.com.condagil.rest.controller.command;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condagil.models.dto.FuncionarioDTO;
import br.com.condagil.service.command.FuncionarioCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "funcionario-command", description = "Funcionários command API")
public class FuncionarioCommandController implements FuncionarioCommandApi {

	@Autowired
	private FuncionarioCommandService funcionarioCommandService;
	
	public FuncionarioDTO novoFuncionario(@Parameter(description="Funcionario") @RequestBody FuncionarioDTO funcionarioDTO) {
		return funcionarioCommandService.salvarFuncionario(funcionarioDTO);
	}
	
	public Map<String, Boolean> deletarFuncionario(@PathVariable Long id){
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		funcionarioCommandService.deletarFuncionario(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}
	
	public FuncionarioDTO atualizarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long id) {
		return funcionarioCommandService.atualizarFuncionario(funcionarioDTO, id);
	}
	
}