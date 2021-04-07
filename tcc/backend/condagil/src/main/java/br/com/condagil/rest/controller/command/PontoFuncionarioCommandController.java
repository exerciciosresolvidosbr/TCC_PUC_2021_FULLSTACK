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

import br.com.condagil.models.dto.PontoFuncionarioDTO;
import br.com.condagil.service.command.PontoFuncionarioCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/ponto", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "ponto-command", description = "Ponto command API")
public class PontoFuncionarioCommandController implements PontoFuncionarioCommandApi{
	
	@Autowired
	private PontoFuncionarioCommandService pontoFuncionarioCommandService;
	
	public PontoFuncionarioDTO novoPontoFuncionario(@Parameter(description="PontoFuncionario") @RequestBody PontoFuncionarioDTO pontoFuncionarioDTO) {
		return pontoFuncionarioCommandService.salvarPontoFuncionario(pontoFuncionarioDTO);
	}
	
	public Map<String, Boolean> deletarPontoFuncionario(@PathVariable Long id) {
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		pontoFuncionarioCommandService.deletarPontoFuncionario(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}

}
