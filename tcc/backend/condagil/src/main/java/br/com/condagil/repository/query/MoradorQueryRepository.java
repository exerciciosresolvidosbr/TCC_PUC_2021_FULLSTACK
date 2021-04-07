package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.Morador;

public interface MoradorQueryRepository {

	public List<Morador> recuperarMoradores();

	public Morador recuperarMoradorPorId(Long moradorId);
	
}
