package br.com.condagil.rest.controller.query;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.ReceitaDTO;
import br.com.condagil.service.query.ReceitaQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/receita", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "receita-query", description = "Receita query API")
public class ReceitaQueryController implements ReceitaQueryApi {

	@Autowired
	private ReceitaQueryService receitaQueryService;
	
	public List<ReceitaDTO> getItensReceita() {
		return receitaQueryService.recuperarReceitas();
	}
	
	public ResponseEntity<ReceitaDTO> getReceita(@PathVariable(value = "id") Long receitaId) throws ResourceNotFoundException {
		ReceitaDTO receitaDTO = receitaQueryService.recuperarReceitaPorId(receitaId);
		if(receitaDTO==null) {
			throw new ResourceNotFoundException("Receita não encontrada com o id :: " + receitaId);
		}
		return ResponseEntity.ok().body(receitaDTO);
	}
	
	public ResponseEntity<InputStreamResource> exportarReceitasPdf(){
		ByteArrayInputStream byteArrayInputStream = receitaQueryService.exportarReceitasPdf();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "inline; filename=receitas.pdf");
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}
}
