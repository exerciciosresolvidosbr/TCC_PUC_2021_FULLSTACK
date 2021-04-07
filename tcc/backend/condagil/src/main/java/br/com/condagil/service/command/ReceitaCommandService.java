package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.ReceitaBuilder;
import br.com.condagil.models.builder.ReceitaDTOBuilder;
import br.com.condagil.models.dto.ReceitaDTO;
import br.com.condagil.models.entity.Receita;
import br.com.condagil.repository.command.ReceitaCommandRepository;

@Service
public class ReceitaCommandService {
	
	@Autowired
	private ReceitaCommandRepository receitaCommandRepository;
	
	public ReceitaDTO salvarReceita(ReceitaDTO receitaDTO) {
		Receita entity = receitaCommandRepository.salvarReceita(
			ReceitaBuilder.getInstance()
				.converterDTOEmReceita(receitaDTO)
				.idNull()
				.getReceita()
		);
		return ReceitaDTOBuilder
				.getInstance()
				.converterEntityEmReceitaDTO(entity)
				.getReceitaDTO();
	}
	
	public void deletarReceita(Long id) {
		receitaCommandRepository.deletarReceita(id);
	}
	
	public ReceitaDTO atualizarReceita(ReceitaDTO receitaDTO, Long id) {
		Receita receita = receitaCommandRepository.recuperarReceitaPorId(id);
		//receita.setDataReceita(receitaDTO.getDataReceitaStr());
		receita.setDescricao(receitaDTO.getDescricao());
		receita.setValor(receitaDTO.getValor());
		return ReceitaDTOBuilder
				.getInstance()
				.converterEntityEmReceitaDTO(receitaCommandRepository.atualizarReceita(receita))
				.getReceitaDTO();
	}
}
