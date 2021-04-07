package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Morador;

@Repository
public class MoradorCommandRepositoryImpl implements MoradorCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public Morador salvarMorador(Morador morador) {
		entityManager.persist(morador);
		return morador;
	}

	@Override
	@Transactional
	public void deletarMorador(Long id) {
		Morador morador = recuperarMoradorPorId(id);
		entityManager.remove(morador);
	}

	@Override
	@Transactional
	public Morador atualizarMorador(Morador morador) {
		return entityManager.merge(morador);
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