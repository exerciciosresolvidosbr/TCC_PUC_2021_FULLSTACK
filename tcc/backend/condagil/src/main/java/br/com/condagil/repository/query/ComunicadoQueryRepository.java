package br.com.condagil.repository.query;

import java.util.List;

import br.com.condagil.models.entity.Comunicado;

public interface ComunicadoQueryRepository {

	public List<Comunicado> recuperarComunicados();

	public Comunicado recuperarComunicadoPorId(Long comunicadoId);
	
}
