package br.com.condagil.repository.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import br.com.condagil.models.entity.oauth.Usuario;

@Repository
public class UsuarioQueryRepositoryImpl implements UsuarioQueryRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> recuperarUsuarios() {
		Query query = entityManager.createQuery("SELECT u FROM Usuario u");
	    return (List<Usuario>) query.getResultList();
	}

	@Override
	public Usuario recuperarUsuarioPorId(Long usuarioId) {
		Usuario usuario = entityManager.find(Usuario.class, usuarioId);
		if(usuario==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não localizado.");
		}
		return usuario;
	}

	public Usuario recuperarPorEmail(String email) {
		Usuario usuario = (Usuario) entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email=:email")
				.setParameter("email", email)
				.getSingleResult();
		if(usuario==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não localizado.");
		}
		return usuario;
	}
	 
    public boolean isEmailCadastrado(String email) {
    	Long total = (Long) entityManager.createQuery("SELECT count(*) FROM Usuario u WHERE u.email=:email")
			.setParameter("email", email)
			.getSingleResult();
    	if(total>1) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mais de um usuário encontrado para o e-mail informado.");
    	}
    	return total>0;
    }
	
}