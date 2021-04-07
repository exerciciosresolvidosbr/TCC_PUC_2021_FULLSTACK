package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.Despesa;

public interface DespesaQueryRepository {

	public List<Despesa> recuperarDespesas();

	public Despesa recuperarDespesaPorId(Long despesaId);
	
}
