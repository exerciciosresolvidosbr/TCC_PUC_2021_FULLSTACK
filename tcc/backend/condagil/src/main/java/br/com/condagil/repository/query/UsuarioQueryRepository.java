package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.oauth.Usuario;

public interface UsuarioQueryRepository {

	public List<Usuario> recuperarUsuarios();

	public Usuario recuperarUsuarioPorId(Long usuarioId);
	
	public Usuario recuperarPorEmail(String email);
	 
    public boolean isEmailCadastrado(String email);
	
}