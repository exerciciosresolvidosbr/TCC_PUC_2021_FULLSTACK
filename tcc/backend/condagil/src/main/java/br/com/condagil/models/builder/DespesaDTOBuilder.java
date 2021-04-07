package br.com.condagil.models.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.condagil.models.dto.DespesaDTO;
import br.com.condagil.models.entity.Despesa;

public class DespesaDTOBuilder {

	private DespesaDTO despesaDTO;

	private DespesaDTOBuilder() {
		super();
		this.despesaDTO = new DespesaDTO();
	}
	
	public static DespesaDTOBuilder getInstance() {
		return new DespesaDTOBuilder();
	}
	
	public DespesaDTOBuilder converterEntityEmDespesaDTO(Despesa entity) {
		despesaDTO.setId(entity.getId());
		//receitaDTO.setDataReceita(entity.getDataReceita());
		despesaDTO.setDescricao(entity.getDescricao());
		despesaDTO.setValor(entity.getValor());
		return this;
	}
	
	public static List<DespesaDTO> converterListaEntityEmDespesaDTO(List<Despesa> listaEntity) {
		List<DespesaDTO> listaDespesasDTO = new ArrayList<DespesaDTO>();
		listaEntity.forEach(entity->{
			listaDespesasDTO.add(
				DespesaDTOBuilder.getInstance()
					.converterEntityEmDespesaDTO(entity)
					.getDespesaDTO()
			);
		});
		return listaDespesasDTO;
	}

	public DespesaDTO getDespesaDTO() {
		return despesaDTO;
	}	
}