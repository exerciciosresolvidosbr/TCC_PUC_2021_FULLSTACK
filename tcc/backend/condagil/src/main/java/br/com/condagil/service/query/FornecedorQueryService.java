package br.com.condagil.service.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.FornecedorDTOBuilder;
import br.com.condagil.models.dto.FornecedorDTO;
import br.com.condagil.repository.query.FornecedorQueryRepository;

@Service
public class FornecedorQueryService {

	@Autowired
	private FornecedorQueryRepository fornecedorQueryRepository;
	
	public List<FornecedorDTO> recuperarFornecedores(){
		List<FornecedorDTO> listaFornecedoresDto = FornecedorDTOBuilder
				.converterListaEntityEmFornecedorDTO(fornecedorQueryRepository.recuperarFornecedores());
		return listaFornecedoresDto;
	}

	public FornecedorDTO recuperarFornecedorPorId(Long FornecedorId) {
		return FornecedorDTOBuilder.getInstance()
				.converterEntityEmFornecedorDTO(fornecedorQueryRepository.recuperarFornecedorPorId(FornecedorId))
				.getFornecedorDTO();
	}	
}