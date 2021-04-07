package br.com.condagil.models.builder;

import br.com.condagil.models.dto.DespesaDTO;
import br.com.condagil.models.entity.Despesa;

public class DespesaBuilder {

	private Despesa despesa;

	private DespesaBuilder() {
		super();
		this.despesa = new Despesa();
	}
	
	public static DespesaBuilder getInstance() {
		return new DespesaBuilder();
	}
	
	public DespesaBuilder converterDTOEmDespesa(DespesaDTO dto) {
		despesa.setId(dto.getId());
		//receita.setDataReceita(dto.getDataReceita());
		despesa.setDescricao(dto.getDescricao());
		despesa.setValor(dto.getValor());
		return this;
	}
	
	public DespesaBuilder idNull() {
		despesa.setId(null);
		return this;
	}

	public Despesa getDespesa() {
		return despesa;
	}
}
