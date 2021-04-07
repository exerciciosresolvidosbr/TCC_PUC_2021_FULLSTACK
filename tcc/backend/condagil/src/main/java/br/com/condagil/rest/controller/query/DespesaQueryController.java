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
import br.com.condagil.models.dto.DespesaDTO;
import br.com.condagil.service.query.DespesaQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/despesa", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "despesa-query", description = "Despesa query API")
public class DespesaQueryController implements DespesaQueryApi {

	@Autowired
	private DespesaQueryService despesaQueryService;
	
	public List<DespesaDTO> getItensDespesa() {
		return despesaQueryService.recuperarDespesas();
	}
	
	public ResponseEntity<DespesaDTO> getDespesa(@PathVariable(value = "id") Long despesaId) throws ResourceNotFoundException {
		DespesaDTO despesaDTO = despesaQueryService.recuperarDespesaPorId(despesaId);
		if(despesaDTO==null) {
			throw new ResourceNotFoundException("Despesa não encontrada com o id :: " + despesaId);
		}
		return ResponseEntity.ok().body(despesaDTO);
	}

	public ResponseEntity<InputStreamResource> exportarDespesasPdf(){
		ByteArrayInputStream byteArrayInputStream = despesaQueryService.exportarDespesasPdf();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "inline; filename=receitas.pdf");
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}
}
