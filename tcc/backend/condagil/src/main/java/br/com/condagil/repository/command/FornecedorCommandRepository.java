package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Fornecedor;

public interface FornecedorCommandRepository {

	public Fornecedor salvarFornecedor(Fornecedor fornecedor);
	
	public void deletarFornecedor(Long id);
	
	public Fornecedor atualizarFornecedor(Fornecedor fornecedor);
	
	public Fornecedor recuperarFornecedorPorId(Long fornecedorId);
	
}