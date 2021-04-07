package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.Fornecedor;

public interface FornecedorQueryRepository {

	public List<Fornecedor> recuperarFornecedores();

	public Fornecedor recuperarFornecedorPorId(Long fornecedorId);
	
}
