package br.com.condagil.service.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.FuncionarioDTOBuilder;
import br.com.condagil.models.dto.FuncionarioDTO;
import br.com.condagil.repository.query.FuncionarioQueryRepository;

@Service
public class FuncionarioQueryService {

	@Autowired
	private FuncionarioQueryRepository funcionarioQueryRepository;
	
	public List<FuncionarioDTO> recuperarFuncionarios(){
		List<FuncionarioDTO> listaFornecedoresDto = FuncionarioDTOBuilder
				.converterListaEntityEmFuncionarioDTO(funcionarioQueryRepository.recuperarFuncionarios());
		return listaFornecedoresDto;
	}

	public FuncionarioDTO recuperarFuncionarioPorId(Long funcionarioId) {
		return FuncionarioDTOBuilder.getInstance()
				.converterEntityEmFuncionarioDTO(funcionarioQueryRepository.recuperarFuncionarioPorId(funcionarioId))
				.getFuncionarioDTO();
	}
	
}