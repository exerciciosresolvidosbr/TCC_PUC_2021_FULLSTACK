package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Receita;

@Repository
public class ReceitaQueryRepositoryImpl implements ReceitaQueryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Receita> recuperarReceitas() {
		Query query = entityManager.createQuery("SELECT r FROM Receita r");
	    return (List<Receita>) query.getResultList();
	}

	@Override
	public Receita recuperarReceitaPorId(Long receitaId) {
		Receita receita = entityManager.find(Receita.class, receitaId);
		if(receita==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comunicado não localizado.");
		}
		return receita;
	}
	
}