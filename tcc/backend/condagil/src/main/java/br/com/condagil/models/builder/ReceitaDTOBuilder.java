package br.com.condagil.models.builder;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.condagil.models.dto.ReceitaDTO;
import br.com.condagil.models.entity.Receita;

public class ReceitaDTOBuilder {

	private ReceitaDTO receitaDTO;

	private ReceitaDTOBuilder() {
		super();
		this.receitaDTO = new ReceitaDTO();
	}
	
	public static ReceitaDTOBuilder getInstance() {
		return new ReceitaDTOBuilder();
	}
	
	public ReceitaDTOBuilder converterEntityEmReceitaDTO(Receita entity) {
		receitaDTO.setId(entity.getId());
		receitaDTO.setDataReceita(entity.getDataReceita().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		receitaDTO.setDescricao(entity.getDescricao());
		receitaDTO.setValor(entity.getValor());
		return this;
	}
	
	public static List<ReceitaDTO> converterListaEntityEmReceitaDTO(List<Receita> listaEntity) {
		List<ReceitaDTO> listaReceitasDTO = new ArrayList<ReceitaDTO>();
		listaEntity.forEach(entity->{
			listaReceitasDTO.add(
				ReceitaDTOBuilder.getInstance()
					.converterEntityEmReceitaDTO(entity)
					.getReceitaDTO()
			);
		});
		return listaReceitasDTO;
	}

	public ReceitaDTO getReceitaDTO() {
		return receitaDTO;
	}

}