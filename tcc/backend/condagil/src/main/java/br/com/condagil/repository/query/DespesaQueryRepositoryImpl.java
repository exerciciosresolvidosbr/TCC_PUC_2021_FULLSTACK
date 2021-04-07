package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Despesa;

@Repository
public class DespesaQueryRepositoryImpl implements DespesaQueryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Despesa> recuperarDespesas() {
		Query query = entityManager.createQuery("SELECT d FROM Despesa d");
	    return (List<Despesa>) query.getResultList();
	}

	@Override
	public Despesa recuperarDespesaPorId(Long despesaId) {
		Despesa despesa = entityManager.find(Despesa.class, despesaId);
		if(despesa==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comunicado não localizado.");
		}
		return despesa;
	}

}
