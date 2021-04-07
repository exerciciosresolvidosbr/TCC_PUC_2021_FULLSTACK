package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Receita;

public interface ReceitaCommandRepository {

	public Receita salvarReceita(Receita receita);
	
	public void deletarReceita(Long id);
	
	public Receita atualizarReceita(Receita receita);
	
	public Receita recuperarReceitaPorId(Long receitaId);
	
}