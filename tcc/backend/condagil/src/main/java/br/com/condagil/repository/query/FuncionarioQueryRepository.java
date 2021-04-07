package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.Funcionario;

public interface FuncionarioQueryRepository {

	public List<Funcionario> recuperarFuncionarios();

	public Funcionario recuperarFuncionarioPorId(Long funcionarioId);
	
}
