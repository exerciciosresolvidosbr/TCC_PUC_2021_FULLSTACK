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

import br.com.condagil.models.dto.DespesaDTO;
import br.com.condagil.service.command.DespesaCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/despesa", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "despesa-command", description = "Despesas command API")
public class DespesaCommandController implements DespesaCommandApi{

	@Autowired
	private DespesaCommandService despesaCommandService;
	
	public DespesaDTO novaDespesa(@Parameter(description="Despesa") @RequestBody DespesaDTO despesaDTO) {
		return despesaCommandService.salvarDespesa(despesaDTO);
	}
	
	public Map<String, Boolean> deletarDespesa(@PathVariable Long id) {
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		despesaCommandService.deletarDespesa(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}
	
	public DespesaDTO atualizarDespesa(@RequestBody DespesaDTO despesaDTO, @PathVariable Long id) {
		return despesaCommandService.atualizarDespesa(despesaDTO, id);
	}
	
}
