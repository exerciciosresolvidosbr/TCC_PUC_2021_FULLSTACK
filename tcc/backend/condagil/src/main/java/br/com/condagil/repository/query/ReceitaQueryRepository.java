package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.Receita;

public interface ReceitaQueryRepository {

	public List<Receita> recuperarReceitas();

	public Receita recuperarReceitaPorId(Long receitaId);
	
}
