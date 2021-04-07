package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Despesa;

public interface DespesaCommandRepository {

	public Despesa salvarDespesa(Despesa despesa);
	
	public void deletarDespesa(Long id);
	
	public Despesa atualizarDespesa(Despesa despesa);
	
	public Despesa recuperarDespesaPorId(Long despesaId);
	
}
