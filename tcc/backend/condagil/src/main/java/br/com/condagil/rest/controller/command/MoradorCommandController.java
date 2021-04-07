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

import br.com.condagil.models.dto.MoradorDTO;
import br.com.condagil.service.command.MoradorCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/morador", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "morador-command", description = "Moradores command API")
public class MoradorCommandController implements MoradorCommandApi{

	@Autowired
	private MoradorCommandService moradorCommandService;
	
	public MoradorDTO novoMorador(@Parameter(description="Morador") @RequestBody MoradorDTO moradorDTO) {
		return moradorCommandService.salvarMorador(moradorDTO);
	}
	
	public Map<String, Boolean> deletarMorador(@PathVariable Long id) {
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		moradorCommandService.deletarMorador(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}
	
	public MoradorDTO atualizarMorador(@RequestBody MoradorDTO moradorDTO, @PathVariable Long id) {
		return moradorCommandService.atualizarMorador(moradorDTO, id);
	}
	
}
