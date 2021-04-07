package br.com.condagil.models.builder;

import br.com.condagil.models.dto.ReceitaDTO;
import br.com.condagil.models.entity.Receita;

public class ReceitaBuilder {

	private Receita receita;

	private ReceitaBuilder() {
		super();
		this.receita = new Receita();
	}
	
	public static ReceitaBuilder getInstance() {
		return new ReceitaBuilder();
	}
	
	public ReceitaBuilder converterDTOEmReceita(ReceitaDTO dto) {
		receita.setId(dto.getId());
		receita.setDataReceita(dto.formatarDataReceitaLocalDateTime());
		receita.setDescricao(dto.getDescricao());
		receita.setValor(dto.getValor());
		return this;
	}
	
	public ReceitaBuilder idNull() {
		receita.setId(null);
		return this;
	}

	public Receita getReceita() {
		return receita;
	}
}
