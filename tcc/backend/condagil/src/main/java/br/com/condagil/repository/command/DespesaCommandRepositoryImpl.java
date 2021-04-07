package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Despesa;

@Repository
public class DespesaCommandRepositoryImpl implements DespesaCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	@Transactional
	public Despesa salvarDespesa(Despesa despesa) {
		entityManager.persist(despesa);
		return despesa;
	}

	@Override
	@Transactional
	public void deletarDespesa(Long id) {
		Despesa despesa = recuperarDespesaPorId(id);
		entityManager.remove(despesa);
	}

	@Override
	@Transactional
	public Despesa atualizarDespesa(Despesa despesa) {
		return entityManager.merge(despesa);
	}
	
	@Override
	public Despesa recuperarDespesaPorId(Long despesaId) {
		Despesa despesa = entityManager.find(Despesa.class, despesaId);
		if(despesa==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Despesa não localizada.");
		}
		return despesa;
	}
	
}