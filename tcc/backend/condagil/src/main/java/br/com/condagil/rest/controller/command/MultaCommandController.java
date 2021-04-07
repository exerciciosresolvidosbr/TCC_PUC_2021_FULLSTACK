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

import br.com.condagil.models.dto.MultaDTO;
import br.com.condagil.service.command.MultaCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/multa", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "multa-command", description = "Multas command API")
public class MultaCommandController implements MultaCommandApi{

	@Autowired
	private MultaCommandService multaCommandService;
	
	public MultaDTO novaMulta(@Parameter(description="Multa") @RequestBody MultaDTO multaDTO) {
		return multaCommandService.salvarMulta(multaDTO);
	}
	
	public Map<String, Boolean> deletarMulta(@PathVariable Long id) {
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		multaCommandService.deletarMulta(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}
	
	public MultaDTO atualizarMulta(@RequestBody MultaDTO multaDTO, @PathVariable Long id) {
		return multaCommandService.atualizarMulta(multaDTO, id);
	}
	
}