package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Funcionario;
import br.com.condagil.models.entity.PontoFuncionario;

public interface PontoFuncionarioCommandRepository {
	
	public PontoFuncionario salvarPontoFuncionario(PontoFuncionario pontoFuncionario);
	
	public Funcionario recuperarFuncionarioPorId(Long funcionarioId);
	
	public void deletarPontoFuncionario(Long id);
	
	public PontoFuncionario recuperarPontoFuncionarioPorId(Long pontoFuncionarioId);

}
