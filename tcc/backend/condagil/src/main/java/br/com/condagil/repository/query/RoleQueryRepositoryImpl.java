package br.com.condagil.repository.query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.oauth.Role;

@Repository
public class RoleQueryRepositoryImpl implements RoleQueryRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Role recuperarPorNome(String name) {
		Role role = (Role) entityManager.createQuery("SELECT r FROM Role r WHERE r.name=:name")
				.setParameter("name", name)
				.getSingleResult();
		if(role==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Role não localizada.");
		}
		return role;
	}
}
