package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.MoradorBuilder;
import br.com.condagil.models.builder.MoradorDTOBuilder;
import br.com.condagil.models.dto.MoradorDTO;
import br.com.condagil.models.entity.Morador;
import br.com.condagil.repository.command.MoradorCommandRepository;

@Service
public class MoradorCommandService {

	@Autowired
	private MoradorCommandRepository moradorCommandRepository;
	
	public MoradorDTO salvarMorador(MoradorDTO MoradorDTO) {
		Morador entity = moradorCommandRepository.salvarMorador(
			MoradorBuilder.getInstance()
				.converterDTOEmMorador(MoradorDTO)
				.idNull()
				.getMorador()
		);
		return MoradorDTOBuilder
				.getInstance()
				.converterEntityEmMoradorDTO(entity)
				.getMoradorDTO();
	}
	
	public void deletarMorador(Long id) {
		moradorCommandRepository.deletarMorador(id);
	}
	
	public MoradorDTO atualizarMorador(MoradorDTO moradorDTO, Long id) {
		Morador morador = moradorCommandRepository.recuperarMoradorPorId(id);
		morador.setCpf(moradorDTO.getCpf());
		morador.setNome(moradorDTO.getNome());
		morador.setEmail(moradorDTO.getEmail());
		morador.setTelefone(moradorDTO.getTelefone());
		morador.setIdentificacaoUnidadeHabitacional(moradorDTO.getIdentificacaoUnidadeHabitacional());
		return MoradorDTOBuilder
				.getInstance()
				.converterEntityEmMoradorDTO(moradorCommandRepository.atualizarMorador(morador))
				.getMoradorDTO();
	}

}