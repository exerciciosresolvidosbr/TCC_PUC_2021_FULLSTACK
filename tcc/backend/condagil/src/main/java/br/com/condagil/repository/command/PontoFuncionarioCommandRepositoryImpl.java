package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Funcionario;
import br.com.condagil.models.entity.PontoFuncionario;

@Repository
public class PontoFuncionarioCommandRepositoryImpl implements PontoFuncionarioCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	@Transactional
	public PontoFuncionario salvarPontoFuncionario(PontoFuncionario pontoFuncionario) {
		entityManager.persist(pontoFuncionario);
		return pontoFuncionario;
	}

	public Funcionario recuperarFuncionarioPorId(Long funcionarioId) {
		Funcionario funcionario = entityManager.find(Funcionario.class, funcionarioId);
		if(funcionario==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não localizado.");
		}
		return funcionario;
	}
	
	@Override
	@Transactional
	public void deletarPontoFuncionario(Long id) {
		PontoFuncionario ponto = recuperarPontoFuncionarioPorId(id);
		entityManager.remove(ponto);
	}
	
	@Override
	public PontoFuncionario recuperarPontoFuncionarioPorId(Long pontoFuncionarioId) {
		PontoFuncionario pontoFuncionario = entityManager.find(PontoFuncionario.class, pontoFuncionarioId);
		if(pontoFuncionario==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ponto não localizado.");
		}
		return pontoFuncionario;
	}
}
