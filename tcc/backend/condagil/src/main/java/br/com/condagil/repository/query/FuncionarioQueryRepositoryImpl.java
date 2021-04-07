package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Funcionario;

@Repository
public class FuncionarioQueryRepositoryImpl implements FuncionarioQueryRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> recuperarFuncionarios(){
		Query query = entityManager.createQuery("SELECT f FROM Funcionario f");
	    return (List<Funcionario>) query.getResultList();
	}

	public Funcionario recuperarFuncionarioPorId(Long funcionarioId) {
		Funcionario funcionario = entityManager.find(Funcionario.class, funcionarioId);
		if(funcionario==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não localizado.");
		}
		return funcionario;
	}
	
}
