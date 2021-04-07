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
import br.com.condagil.models.dto.ComunicadoDTO;
import br.com.condagil.service.query.ComunicadoQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/comunicado", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "comunicado-query", description = "Comunicado query API")
public class ComunicadoQueryController implements ComunicadoQueryApi{

	@Autowired
	private ComunicadoQueryService comunicadoQueryService;
	
	public List<ComunicadoDTO> getItensComunicado() {
		return comunicadoQueryService.recuperarComunicados();
	}
	
	public ResponseEntity<ComunicadoDTO> getComunicado(@PathVariable(value = "id") Long comunicadoId) throws ResourceNotFoundException {
		ComunicadoDTO ComunicadoDTO = comunicadoQueryService.recuperarComunicadoPorId(comunicadoId);
		if(ComunicadoDTO==null) {
			throw new ResourceNotFoundException("Comunicado não encontrado com o id :: " + comunicadoId);
		}
		return ResponseEntity.ok().body(ComunicadoDTO);
	}
	
	public ResponseEntity<InputStreamResource> exportarComunicadoPdf(@PathVariable(value = "id") Long comunicadoId) throws ResourceNotFoundException{
		ByteArrayInputStream byteArrayInputStream = comunicadoQueryService.exportarComunicadoPdf(comunicadoId);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-Disposition", "inline; filename=receitas.pdf");
		return ResponseEntity
				.ok()
				.headers(httpHeaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(byteArrayInputStream));
	}
}
