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
import br.com.condagil.models.dto.MultaDTO;
import br.com.condagil.service.query.MultaQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/multa", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "multa-query", description = "Multa query API")
public class MultaQueryController implements MultaQueryApi{

	@Autowired
	private MultaQueryService multaQueryService;
	
	public List<MultaDTO> getItensMulta() {
		return multaQueryService.recuperarMultas();
	}
	
	public ResponseEntity<MultaDTO> getMulta(@PathVariable(value = "id") Long multaId) throws ResourceNotFoundException {
		MultaDTO multaDTO = multaQueryService.recuperarMultaPorId(multaId);
		if(multaDTO==null) {
			throw new ResourceNotFoundException("Multa não encontrada com o id :: " + multaId);
		}
		return ResponseEntity.ok().body(multaDTO);
	}
	
	public ResponseEntity<InputStreamResource> exportarMultaPdf(@PathVariable(value = "id") Long multaId) throws ResourceNotFoundException{
		ByteArrayInputStream byteArrayInputStream = multaQueryService.exportarMultaPdf(multaId);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "inline; filename=receitas.pdf");
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}
}
