package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Comunicado;

@Repository
public class ComunicadoCommandRepositoryImpl implements ComunicadoCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	@Transactional
	public Comunicado salvarComunicado(Comunicado comunicado) {
		entityManager.persist(comunicado);
		return comunicado;
	}

	@Override
	@Transactional
	public void deletarComunicado(Long id) {
		Comunicado comunicado = recuperarComunicadoPorId(id);
		entityManager.remove(comunicado);
	}

	@Override
	@Transactional
	public Comunicado atualizarComunicado(Comunicado comunicado) {
		return entityManager.merge(comunicado);
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
