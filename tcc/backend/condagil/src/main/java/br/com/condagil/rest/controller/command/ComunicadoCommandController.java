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

import br.com.condagil.models.dto.ComunicadoDTO;
import br.com.condagil.service.command.ComunicadoCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/comunicado", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "comunicado-command", description = "Comunicados command API")
public class ComunicadoCommandController implements ComunicadoCommandApi{

	@Autowired
	private ComunicadoCommandService comunicadoCommandService;
	
	public ComunicadoDTO novoComunicado(@Parameter(description="Comunicado") @RequestBody ComunicadoDTO ComunicadoDTO) {
		return comunicadoCommandService.salvarComunicado(ComunicadoDTO);
	}
	
	public Map<String, Boolean> deletarComunicado(@PathVariable Long id) {
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		comunicadoCommandService.deletarComunicado(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}
	
	public ComunicadoDTO atualizarComunicado(@RequestBody ComunicadoDTO comunicadoDTO, @PathVariable Long id) {
		return comunicadoCommandService.atualizarComunicado(comunicadoDTO, id);
	}
	
}
