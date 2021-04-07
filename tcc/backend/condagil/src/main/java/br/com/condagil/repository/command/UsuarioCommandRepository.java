package br.com.condagil.repository.command;

import br.com.condagil.models.entity.oauth.Usuario;

public interface UsuarioCommandRepository {

	public Usuario salvarUsuario(Usuario usuario);
	
	public void deletarUsuario(Long id);
	
	public Usuario atualizarUsuario(Usuario usuario);
	
	public Usuario recuperarUsuarioPorId(Long usuarioId);
	
	public Usuario recuperarPorEmail(String email);
	
	public boolean isEmailCadastrado(String email);
	
}