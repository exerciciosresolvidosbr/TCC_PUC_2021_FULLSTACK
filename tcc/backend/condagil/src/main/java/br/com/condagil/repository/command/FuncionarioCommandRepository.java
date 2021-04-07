package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Funcionario;

public interface FuncionarioCommandRepository {

	public Funcionario salvarFuncionario(Funcionario funcionario);
	
	public void deletarFuncionario(Long id);
	
	public Funcionario atualizarFuncionario(Funcionario funcionario);
	
	public Funcionario recuperarFuncionarioPorId(Long funcionarioId);
	
}