package br.com.condagil.rest.controller.oauth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.service.oauth.UsuarioCommandService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/command/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Tag(name = "usuario-command", description = "Usuarios command API")
public class UsuarioCommandController implements UsuarioCommandApi{

	@Autowired
	private UsuarioCommandService usuarioCommandService;
	
	public UsuarioDTO novoUsuario(@Parameter(description="Usuario") @RequestBody UsuarioDTO usuarioDTO) {
		return usuarioCommandService.salvarUsuario(usuarioDTO);
	}
	
	public Map<String, Boolean> deletarUsurio(@PathVariable Long id){
		Map<String, Boolean> retorno = new HashMap<String, Boolean>();
		usuarioCommandService.deletarUsuario(id);
		retorno.put("deletado", Boolean.TRUE);
		return retorno;
	}

	public UsuarioDTO atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id) {
		return usuarioCommandService.atualizarUsuario(usuarioDTO, id);
	}
	
}
