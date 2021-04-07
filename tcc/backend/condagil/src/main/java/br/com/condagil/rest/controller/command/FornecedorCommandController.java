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

import br.com.condagil.models.dto.FornecedorDTO;
import br.com.condagil.service.command.FornecedorCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/fornecedor", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "fornecedor-command", description = "Fornecedores command API")
public class FornecedorCommandController implements FornecedorCommandApi {

	@Autowired
	private FornecedorCommandService fornecedorCommandService;
	
	public FornecedorDTO novoFornecedor(@Parameter(description="Fornecedor") @RequestBody FornecedorDTO fornecedorDTO) {
		return fornecedorCommandService.salvarFornecedor(fornecedorDTO);
	}
	
	public Map<String, Boolean> deletarFornecedor(@PathVariable Long id) {
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		fornecedorCommandService.deletarFornecedor(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}
	
	public FornecedorDTO atualizarFornecedor(@RequestBody FornecedorDTO fornecedorDTO, @PathVariable Long id) {
		return fornecedorCommandService.atualizarFornecedor(fornecedorDTO, id);
	}
	
}