package br.com.condagil.models.builder.oauth;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.models.entity.oauth.Role;
import br.com.condagil.models.entity.oauth.Usuario;

public class UsuarioBuilder {

	private Usuario usuario;
	
	private UsuarioBuilder() {
		super();
		this.usuario = new Usuario();
	}
	
	public static UsuarioBuilder getInstance() {
		return new UsuarioBuilder();
	}

	public UsuarioBuilder converterDTOEmUsuario(UsuarioDTO dto, String encodedPassword, Role role) {
		usuario.setId(dto.getId());
		usuario.setProviderUserId(dto.getProviderUserId());
		usuario.setEmail(dto.getEmail());
		usuario.setEnabled(dto.getEnabled());
		usuario.setDisplayName(dto.getDisplayName());
		usuario.setPassword(encodedPassword);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		usuario.setRoles(roles);
		usuario.setProvider(dto.getProvider());
		return this;
	}
	
	public UsuarioBuilder addDataCorrenteCreatedDate() {
		usuario.setCreatedDate(Calendar.getInstance().getTime());
		return this;
	}
	
	public UsuarioBuilder addDataCorrenteModifiedDate() {
		usuario.setModifiedDate(Calendar.getInstance().getTime());
		return this;
	}
	
	public UsuarioBuilder idNull() {
		usuario.setId(null);
		return this;
	}

	public UsuarioBuilder replaceUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
}
