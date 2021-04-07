package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Multa;

@Repository
public class MultaQueryRepositoryImpl implements MultaQueryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Multa> recuperarMultas() {
		Query query = entityManager.createQuery("SELECT m FROM Multa m");
	    return (List<Multa>) query.getResultList();
	}

	@Override
	public Multa recuperarMultaPorId(Long multaId) {
		Multa multa = entityManager.find(Multa.class, multaId);
		if(multa==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comunicado não localizado.");
		}
		return multa;
	}

}
