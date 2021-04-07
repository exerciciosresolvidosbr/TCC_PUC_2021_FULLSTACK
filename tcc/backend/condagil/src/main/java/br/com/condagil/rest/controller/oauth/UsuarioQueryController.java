package br.com.condagil.rest.controller.oauth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condagil.config.oauth.CurrentUser;
import br.com.condagil.exception.ResourceNotFoundException;
import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.models.dto.oauth.UsuarioLocalDTO;
import br.com.condagil.service.oauth.UsuarioQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/query/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "usuario-query", description = "Usuario query API")
public class UsuarioQueryController implements UsuarioQueryApi {

	@Autowired
	private UsuarioQueryService usuarioQueryService;
	
	public List<UsuarioDTO> getItensUsuario() {
		return usuarioQueryService.recuperarUsuarios();
	}
	
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable(value = "id") Long usuarioId) throws ResourceNotFoundException {
		UsuarioDTO usuarioDTO = usuarioQueryService.recuperarUsuarioPorId(usuarioId);
		if(usuarioDTO==null) {
			throw new ResourceNotFoundException("Usuário não encontrado com o id :: " + usuarioId);
		}
		return ResponseEntity.ok().body(usuarioDTO);
	}

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getCurrentUser(@CurrentUser UsuarioLocalDTO user) {
        return ResponseEntity.ok(user);
    }
}
