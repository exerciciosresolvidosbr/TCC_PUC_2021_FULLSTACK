package br.com.condagil.models.builder;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import br.com.condagil.models.dto.PontoFuncionarioDTO;
import br.com.condagil.models.entity.PontoFuncionario;

public class PontoFuncionarioDTOBuilder {

	private PontoFuncionarioDTO pontoFuncionarioDTO;

	private PontoFuncionarioDTOBuilder() {
		super();
		this.pontoFuncionarioDTO = new PontoFuncionarioDTO();
	}
	
	public static PontoFuncionarioDTOBuilder getInstance() {
		return new PontoFuncionarioDTOBuilder();
	}
	
	public PontoFuncionarioDTOBuilder converterEntityEmPontoFuncionarioDTO(PontoFuncionario entity) {		
		pontoFuncionarioDTO.setId(entity.getId());
		pontoFuncionarioDTO.setEntrada(entity.getEntrada().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		pontoFuncionarioDTO.setSaida(entity.getSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return this;
	}
	
	public static Set<PontoFuncionarioDTO> converterListaEntityEmPontoFuncionarioDTO(Set<PontoFuncionario> listaEntity) {
		Set<PontoFuncionarioDTO> listaPontoFuncionarioDTO = new HashSet<PontoFuncionarioDTO>();
		listaEntity.forEach(entity->{
			listaPontoFuncionarioDTO.add(
				PontoFuncionarioDTOBuilder.getInstance()
					.converterEntityEmPontoFuncionarioDTO(entity)
					.getPontoFuncionarioDTO()
			);
		});
		return listaPontoFuncionarioDTO;
	}

	public PontoFuncionarioDTO getPontoFuncionarioDTO() {
		return pontoFuncionarioDTO;
	}
	
}