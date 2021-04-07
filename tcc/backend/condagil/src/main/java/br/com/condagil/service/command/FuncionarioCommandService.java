package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.FuncionarioBuilder;
import br.com.condagil.models.builder.FuncionarioDTOBuilder;
import br.com.condagil.models.dto.FuncionarioDTO;
import br.com.condagil.models.entity.Funcionario;
import br.com.condagil.repository.command.FuncionarioCommandRepository;

@Service
public class FuncionarioCommandService {

	@Autowired
	private FuncionarioCommandRepository funcionarioCommandRepository;
	
	public FuncionarioDTO salvarFuncionario(FuncionarioDTO funcionarioDTO) {
		Funcionario entity = funcionarioCommandRepository.salvarFuncionario(
			FuncionarioBuilder.getInstance()
				.converterDTOEmFuncionario(funcionarioDTO)
				.idNull()
				.getFuncionario()
		);
		return FuncionarioDTOBuilder
				.getInstance()
				.converterEntityEmFuncionarioDTO(entity)
				.getFuncionarioDTO();
	}
	
	public void deletarFuncionario(Long id) {
		funcionarioCommandRepository.deletarFuncionario(id);
	}
	
	public FuncionarioDTO atualizarFuncionario(FuncionarioDTO funcionarioDTO, Long id) {
		Funcionario funcionario = funcionarioCommandRepository.recuperarFuncionarioPorId(id);
		funcionario.setDataAdmissao(funcionarioDTO.formatarDataAdmissaoLocalDateTime());
		funcionario.setDataDemissao(funcionarioDTO.formatarDataDemissaoLocalDateTime());
		return FuncionarioDTOBuilder
				.getInstance()
				.converterEntityEmFuncionarioDTO(funcionarioCommandRepository.atualizarFuncionario(funcionario))
				.getFuncionarioDTO();
	}
}