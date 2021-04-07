package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Comunicado;

@Repository
public class ComunicadoQueryRepositoryImpl implements ComunicadoQueryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Comunicado> recuperarComunicados() {
		Query query = entityManager.createQuery("SELECT c FROM Comunicado c");
	    return (List<Comunicado>) query.getResultList();
	}

	@Override
	public Comunicado recuperarComunicadoPorId(Long comunicadoId) {
		Comunicado comunicado = entityManager.find(Comunicado.class, comunicadoId);
		if(comunicado==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comunicado não localizado.");
		}
		return comunicado;
	}
	
}
