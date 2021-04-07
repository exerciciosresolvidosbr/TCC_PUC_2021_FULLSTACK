package br.com.condagil.models.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.condagil.models.dto.MoradorDTO;
import br.com.condagil.models.entity.Morador;

public class MoradorDTOBuilder {

	private MoradorDTO moradorDTO;

	private MoradorDTOBuilder() {
		super();
		this.moradorDTO = new MoradorDTO();
	}
	
	public static MoradorDTOBuilder getInstance() {
		return new MoradorDTOBuilder();
	}
	
	public MoradorDTOBuilder converterEntityEmMoradorDTO(Morador entity) {
		moradorDTO.setId(entity.getId());
		moradorDTO.setCpf(entity.getCpf());
		moradorDTO.setNome(entity.getNome());
		moradorDTO.setEmail(entity.getNome());
		moradorDTO.setTelefone(entity.getTelefone());
		moradorDTO.setIdentificacaoUnidadeHabitacional(entity.getIdentificacaoUnidadeHabitacional());
		return this;
	}
	
	public static List<MoradorDTO> converterListaEntityEmMoradorDTO(List<Morador> listaEntity) {
		List<MoradorDTO> listaDespesasDTO = new ArrayList<MoradorDTO>();
		listaEntity.forEach(entity->{
			listaDespesasDTO.add(
				MoradorDTOBuilder.getInstance()
					.converterEntityEmMoradorDTO(entity)
					.getMoradorDTO()
			);
		});
		return listaDespesasDTO;
	}

	public MoradorDTO getMoradorDTO() {
		return moradorDTO;
	}
	
}
