package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.PontoFuncionarioBuilder;
import br.com.condagil.models.builder.PontoFuncionarioDTOBuilder;
import br.com.condagil.models.dto.PontoFuncionarioDTO;
import br.com.condagil.models.entity.Funcionario;
import br.com.condagil.models.entity.PontoFuncionario;
import br.com.condagil.repository.command.PontoFuncionarioCommandRepository;

@Service
public class PontoFuncionarioCommandService {

	@Autowired
	private PontoFuncionarioCommandRepository pontoFuncionarioCommandRepository;
	
	public PontoFuncionarioDTO salvarPontoFuncionario(PontoFuncionarioDTO pontoFuncionarioDTO) {
		Funcionario funcionario = pontoFuncionarioCommandRepository.recuperarFuncionarioPorId(pontoFuncionarioDTO.getIdFuncionario());
		PontoFuncionario entity = pontoFuncionarioCommandRepository.salvarPontoFuncionario(
			PontoFuncionarioBuilder.getInstance()
				.converterDTOEmPontoFuncionario(pontoFuncionarioDTO)
				.idNull()
				.addFuncionario(funcionario)
				.getPontoFuncionario()
		);
		return PontoFuncionarioDTOBuilder
				.getInstance()
				.converterEntityEmPontoFuncionarioDTO(entity)
				.getPontoFuncionarioDTO();
	}
	
	public void deletarPontoFuncionario(Long id) {
		pontoFuncionarioCommandRepository.deletarPontoFuncionario(id);
	}
	
}
