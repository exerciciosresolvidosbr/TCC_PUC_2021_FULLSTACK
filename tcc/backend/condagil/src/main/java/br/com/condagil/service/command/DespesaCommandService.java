package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.DespesaBuilder;
import br.com.condagil.models.builder.DespesaDTOBuilder;
import br.com.condagil.models.dto.DespesaDTO;
import br.com.condagil.models.entity.Despesa;
import br.com.condagil.repository.command.DespesaCommandRepository;

@Service
public class DespesaCommandService {

	@Autowired
	private DespesaCommandRepository despesaCommandRepository;
	
	public DespesaDTO salvarDespesa(DespesaDTO DespesaDTO) {
		Despesa entity = despesaCommandRepository.salvarDespesa(
			DespesaBuilder.getInstance()
				.converterDTOEmDespesa(DespesaDTO)
				.idNull()
				.getDespesa()
		);
		return DespesaDTOBuilder
				.getInstance()
				.converterEntityEmDespesaDTO(entity)
				.getDespesaDTO();
	}
	
	public void deletarDespesa(Long id) {
		despesaCommandRepository.deletarDespesa(id);
	}
	
	public DespesaDTO atualizarDespesa(DespesaDTO DespesaDTO, Long id) {
		Despesa Despesa = despesaCommandRepository.recuperarDespesaPorId(id);
		//Despesa.setDataDespesa(DespesaDTO.getDataDespesaStr());
		Despesa.setDescricao(DespesaDTO.getDescricao());
		Despesa.setValor(DespesaDTO.getValor());
		return DespesaDTOBuilder
				.getInstance()
				.converterEntityEmDespesaDTO(despesaCommandRepository.atualizarDespesa(Despesa))
				.getDespesaDTO();
	}
}
