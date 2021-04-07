package br.com.condagil.models.builder;

import br.com.condagil.models.dto.MoradorDTO;
import br.com.condagil.models.entity.Morador;

public class MoradorBuilder {

	private Morador morador;

	private MoradorBuilder() {
		super();
		this.morador = new Morador();
	}
	
	public static MoradorBuilder getInstance() {
		return new MoradorBuilder();
	}
	
	public MoradorBuilder converterDTOEmMorador(MoradorDTO dto) {
		morador.setId(dto.getId());
		morador.setCpf(dto.getCpf());
		morador.setNome(dto.getNome());
		morador.setEmail(dto.getNome());
		morador.setTelefone(dto.getTelefone());
		morador.setIdentificacaoUnidadeHabitacional(dto.getIdentificacaoUnidadeHabitacional());
		return this;
	}
	
	public MoradorBuilder idNull() {
		morador.setId(null);
		return this;
	}

	public Morador getMorador() {
		return morador;
	}
}
