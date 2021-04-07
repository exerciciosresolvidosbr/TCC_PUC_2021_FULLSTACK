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
import br.com.condagil.models.dto.FornecedorDTO;
import br.com.condagil.service.query.FornecedorQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/fornecedor", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "fornecedor-query", description = "Fornecedor query API")
public class FornecedorQueryController implements FornecedorQueryApi{

	@Autowired
	private FornecedorQueryService fornecedorQueryService;
	
	public List<FornecedorDTO> getItensFornecedor() {
		return fornecedorQueryService.recuperarFornecedores();
	}
	
	public ResponseEntity<FornecedorDTO> getFornecedor(@PathVariable(value = "id") Long fornecedorId) throws ResourceNotFoundException {
		FornecedorDTO fornecedorDTO = fornecedorQueryService.recuperarFornecedorPorId(fornecedorId);
		if(fornecedorDTO==null) {
			throw new ResourceNotFoundException("Fornecedor não encontrado com o id :: " + fornecedorId);
		}
		return ResponseEntity.ok().body(fornecedorDTO);
	}

}
