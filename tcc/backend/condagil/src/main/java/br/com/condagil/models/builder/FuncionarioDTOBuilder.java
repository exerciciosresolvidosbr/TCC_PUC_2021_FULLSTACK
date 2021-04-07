package br.com.condagil.models.builder;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.condagil.models.dto.FuncionarioDTO;
import br.com.condagil.models.entity.Funcionario;

public class FuncionarioDTOBuilder {

	private FuncionarioDTO funcionarioDTO;

	private FuncionarioDTOBuilder() {
		super();
		this.funcionarioDTO = new FuncionarioDTO();
	}
	
	public static FuncionarioDTOBuilder getInstance() {
		return new FuncionarioDTOBuilder();
	}
	
	public FuncionarioDTOBuilder converterEntityEmFuncionarioDTO(Funcionario entity) {
		funcionarioDTO.setId(entity.getId());
		funcionarioDTO.setNome(entity.getNome());
		funcionarioDTO.setDataAdmissao(entity.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		funcionarioDTO.setDataDemissao(entity.getDataDemissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		if(entity.getPontosFuncionario()!=null) {
			funcionarioDTO.setPontosFuncionarioDTO((PontoFuncionarioDTOBuilder.converterListaEntityEmPontoFuncionarioDTO(entity.getPontosFuncionario())));
		}
		return this;
	}
	
	public static List<FuncionarioDTO> converterListaEntityEmFuncionarioDTO(List<Funcionario> listaEntity) {
		List<FuncionarioDTO> listaFuncionariosDTO = new ArrayList<FuncionarioDTO>();
		listaEntity.forEach(entity->{
			listaFuncionariosDTO.add(
				FuncionarioDTOBuilder.getInstance()
					.converterEntityEmFuncionarioDTO(entity)
					.getFuncionarioDTO()
			);
		});
		return listaFuncionariosDTO;
	}

	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}
	
}
