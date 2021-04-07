package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.Multa;

public interface MultaQueryRepository {

	public List<Multa> recuperarMultas();

	public Multa recuperarMultaPorId(Long multaId);
	
}