package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Comunicado;

public interface ComunicadoCommandRepository {

	public Comunicado salvarComunicado(Comunicado comunicado);
	
	public void deletarComunicado(Long id);
	
	public Comunicado atualizarComunicado(Comunicado comunicado);
	
	public Comunicado recuperarComunicadoPorId(Long comunicadoId);
	
}