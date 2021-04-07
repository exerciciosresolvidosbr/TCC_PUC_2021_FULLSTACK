package br.com.condagil.service.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.MoradorDTOBuilder;
import br.com.condagil.models.dto.MoradorDTO;
import br.com.condagil.repository.query.MoradorQueryRepository;

@Service
public class MoradorQueryService {

	@Autowired
	private MoradorQueryRepository moradorQueryRepository;
	
	public List<MoradorDTO> recuperarMoradors(){
		List<MoradorDTO> listaMoradorsDto = MoradorDTOBuilder
				.converterListaEntityEmMoradorDTO(moradorQueryRepository.recuperarMoradores());
		return listaMoradorsDto;
	}

	public MoradorDTO recuperarMoradorPorId(Long MoradorId) {
		return MoradorDTOBuilder.getInstance()
				.converterEntityEmMoradorDTO(moradorQueryRepository.recuperarMoradorPorId(MoradorId))
				.getMoradorDTO();
	}

	
}
