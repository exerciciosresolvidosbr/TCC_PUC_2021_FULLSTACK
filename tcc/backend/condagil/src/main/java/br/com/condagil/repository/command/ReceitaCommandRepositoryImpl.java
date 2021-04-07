package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Receita;

@Repository
public class ReceitaCommandRepositoryImpl implements ReceitaCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	@Transactional
	public Receita salvarReceita(Receita receita) {
		entityManager.persist(receita);
		return receita;
	}

	@Override
	@Transactional
	public void deletarReceita(Long id) {
		Receita receita = recuperarReceitaPorId(id);
		entityManager.remove(receita);
	}

	@Override
	@Transactional
	public Receita atualizarReceita(Receita receita) {
		return entityManager.merge(receita);
	}
	
	@Override
	public Receita recuperarReceitaPorId(Long receitaId) {
		Receita receita = entityManager.find(Receita.class, receitaId);
		if(receita==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Receita não localizado.");
		}
		return receita;
	}
	
}
