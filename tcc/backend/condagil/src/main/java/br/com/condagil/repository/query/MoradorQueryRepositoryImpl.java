package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Morador;

@Repository
public class MoradorQueryRepositoryImpl implements MoradorQueryRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Morador> recuperarMoradores() {
		Query query = entityManager.createQuery("SELECT m FROM Morador m");
	    return (List<Morador>) query.getResultList();
	}

	@Override
	public Morador recuperarMoradorPorId(Long moradorId) {
		Morador morador = entityManager.find(Morador.class, moradorId);
		if(morador==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Morador não localizado.");
		}
		return morador;
	}
}