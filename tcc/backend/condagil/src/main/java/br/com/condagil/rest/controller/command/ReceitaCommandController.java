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

import br.com.condagil.models.dto.ReceitaDTO;
import br.com.condagil.service.command.ReceitaCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/receita", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "receita-command", description = "Receitas command API")
public class ReceitaCommandController implements ReceitaCommandApi{

	@Autowired
	private ReceitaCommandService receitaCommandService;
	
	public ReceitaDTO novaReceita(@Parameter(description="Receita") @RequestBody ReceitaDTO receitaDTO) {
		return receitaCommandService.salvarReceita(receitaDTO);
	}
	
	public Map<String, Boolean> deletarReceita(@PathVariable Long id) {
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		receitaCommandService.deletarReceita(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}
	
	public ReceitaDTO atualizarReceita(@RequestBody ReceitaDTO receitaDTO, @PathVariable Long id) {
		return receitaCommandService.atualizarReceita(receitaDTO, id);
	}

}
