package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Funcionario;

@Repository
public class FuncionarioCommandRepositoryImpl implements FuncionarioCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	@Transactional
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		entityManager.persist(funcionario);
		return funcionario;
	}
	
	@Override 
	@Transactional
	public void deletarFuncionario(Long id) {
		Funcionario funcionario = recuperarFuncionarioPorId(id);
		entityManager.remove(funcionario);
	}
	
	@Override 
	@Transactional
	public Funcionario atualizarFuncionario(Funcionario funcionario) {
		return entityManager.merge(funcionario);
	}
	
	public Funcionario recuperarFuncionarioPorId(Long funcionarioId) {
		Funcionario funcionario = entityManager.find(Funcionario.class, funcionarioId);
		if(funcionario==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não localizado.");
		}
		return funcionario;
	}
	
}
