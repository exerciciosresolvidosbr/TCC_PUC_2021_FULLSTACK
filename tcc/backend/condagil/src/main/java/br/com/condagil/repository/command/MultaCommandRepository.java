package br.com.condagil.repository.command;

import br.com.condagil.models.entity.Multa;

public interface MultaCommandRepository {

	public Multa salvarMulta(Multa multa);
	
	public void deletarMulta(Long id);
	
	public Multa atualizarMulta(Multa multa);
	
	public Multa recuperarMultaPorId(Long multaId);
	
}