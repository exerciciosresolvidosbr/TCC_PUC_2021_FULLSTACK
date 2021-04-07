package br.com.condagil.models.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.condagil.models.dto.FornecedorDTO;
import br.com.condagil.models.entity.Fornecedor;

public class FornecedorDTOBuilder {

	private FornecedorDTO fornecedorDTO;

	private FornecedorDTOBuilder() {
		super();
		this.fornecedorDTO = new FornecedorDTO();
	}
	
	public static FornecedorDTOBuilder getInstance() {
		return new FornecedorDTOBuilder();
	}
	
	public FornecedorDTOBuilder converterEntityEmFornecedorDTO(Fornecedor entity) {
		fornecedorDTO.setId(entity.getId());
		fornecedorDTO.setNome(entity.getNome());
		fornecedorDTO.setDocIdentificacao(entity.getDocIdentificacao());
		fornecedorDTO.setProdutoServico(entity.getProdutoServico());
		return this;
	}
	
	public static List<FornecedorDTO> converterListaEntityEmFornecedorDTO(List<Fornecedor> listaEntity) {
		List<FornecedorDTO> listaFornecedorDTO = new ArrayList<FornecedorDTO>();
		listaEntity.forEach(entity->{
			listaFornecedorDTO.add(
				FornecedorDTOBuilder.getInstance()
					.converterEntityEmFornecedorDTO(entity)
					.getFornecedorDTO()
			);
		});
		return listaFornecedorDTO;
	}

	public FornecedorDTO getFornecedorDTO() {
		return fornecedorDTO;
	}
	
}
