package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Multa;

@Repository
public class MultaCommandRepositoryImpl implements MultaCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Multa salvarMulta(Multa multa) {
		entityManager.persist(multa);
		return multa;
	}

	@Override
	@Transactional
	public void deletarMulta(Long id) {
		Multa multa = recuperarMultaPorId(id);
		entityManager.remove(multa);
	}

	@Override
	@Transactional
	public Multa atualizarMulta(Multa multa) {
		return entityManager.merge(multa);
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