package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.Fornecedor;

@Repository
public class FornecedorQueryRepositoryImpl implements FornecedorQueryRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> recuperarFornecedores() {
		Query query = entityManager.createQuery("SELECT f FROM Fornecedor f");
	    return (List<Fornecedor>) query.getResultList();
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
