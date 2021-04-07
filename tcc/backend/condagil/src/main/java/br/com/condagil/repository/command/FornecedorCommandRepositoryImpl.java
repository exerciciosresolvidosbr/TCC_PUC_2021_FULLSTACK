package br.com.condagil.repository.command;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Fornecedor;

@Repository
public class FornecedorCommandRepositoryImpl implements FornecedorCommandRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	@Transactional
	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		entityManager.persist(fornecedor);
		return fornecedor;
	}

	@Override
	@Transactional
	public void deletarFornecedor(Long id) {
		Fornecedor fornecedor = recuperarFornecedorPorId(id);
		entityManager.remove(fornecedor);
	}

	@Override
	@Transactional
	public Fornecedor atualizarFornecedor(Fornecedor fornecedor) {
		return entityManager.merge(fornecedor);
	}
	
	@Override
	public Fornecedor recuperarFornecedorPorId(Long fornecedorId) {
		Fornecedor fornecedor = entityManager.find(Fornecedor.class, fornecedorId);
		if(fornecedor==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor não localizado.");
		}
		return fornecedor;
	}


}
