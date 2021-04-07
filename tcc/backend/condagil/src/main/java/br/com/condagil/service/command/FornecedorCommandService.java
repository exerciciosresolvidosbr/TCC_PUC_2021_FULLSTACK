package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.FornecedorBuilder;
import br.com.condagil.models.builder.FornecedorDTOBuilder;
import br.com.condagil.models.dto.FornecedorDTO;
import br.com.condagil.models.entity.Fornecedor;
import br.com.condagil.repository.command.FornecedorCommandRepository;

@Service
public class FornecedorCommandService {

	@Autowired
	private FornecedorCommandRepository fornecedorCommandRepository;
	
	public FornecedorDTO salvarFornecedor(FornecedorDTO fornecedorDTO) {
		Fornecedor entity = fornecedorCommandRepository.salvarFornecedor(
			FornecedorBuilder.getInstance()
				.converterDTOEmFornecedor(fornecedorDTO)
				.idNull()
				.getFornecedor()
		);
		return FornecedorDTOBuilder
				.getInstance()
				.converterEntityEmFornecedorDTO(entity)
				.getFornecedorDTO();
	}
	
	public void deletarFornecedor(Long id) {
		fornecedorCommandRepository.deletarFornecedor(id);
	}
	
	public FornecedorDTO atualizarFornecedor(FornecedorDTO fornecedorDTO, Long id) {
		Fornecedor fornecedor = fornecedorCommandRepository.recuperarFornecedorPorId(id);
		fornecedor.setNome(fornecedorDTO.getNome());
		fornecedor.setDocIdentificacao(fornecedorDTO.getDocIdentificacao());
		fornecedor.setProdutoServico(fornecedorDTO.getProdutoServico());
		return FornecedorDTOBuilder
				.getInstance()
				.converterEntityEmFornecedorDTO(fornecedorCommandRepository.atualizarFornecedor(fornecedor))
				.getFornecedorDTO();
	}
}
