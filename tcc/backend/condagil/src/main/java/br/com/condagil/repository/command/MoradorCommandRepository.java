package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Morador;

public interface MoradorCommandRepository {

	public Morador salvarMorador(Morador morador);
	
	public void deletarMorador(Long id);
	
	public Morador atualizarMorador(Morador morador);
	
	public Morador recuperarMoradorPorId(Long moradorId);
	
}
