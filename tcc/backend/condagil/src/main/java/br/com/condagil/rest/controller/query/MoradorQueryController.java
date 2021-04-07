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
import br.com.condagil.models.dto.MoradorDTO;
import br.com.condagil.service.query.MoradorQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/morador", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "morador-query", description = "Morador query API")
public class MoradorQueryController implements MoradorQueryApi{

	@Autowired
	private MoradorQueryService moradorQueryService;
	
	public List<MoradorDTO> getItensMorador() {
		return moradorQueryService.recuperarMoradors();
	}
	
	public ResponseEntity<MoradorDTO> getMorador(@PathVariable(value = "id") Long moradorId) throws ResourceNotFoundException {
		MoradorDTO moradorDTO = moradorQueryService.recuperarMoradorPorId(moradorId);
		if(moradorDTO==null) {
			throw new ResourceNotFoundException("Morador não encontrada com o id :: " + moradorId);
		}
		return ResponseEntity.ok().body(moradorDTO);
	}
	
}