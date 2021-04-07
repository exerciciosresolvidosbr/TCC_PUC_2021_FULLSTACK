package br.com.condagil.repository.query;

import br.com.condagil.models.entity.oauth.Role;

public interface RoleQueryRepository {

	public Role recuperarPorNome(String nome);
	
}