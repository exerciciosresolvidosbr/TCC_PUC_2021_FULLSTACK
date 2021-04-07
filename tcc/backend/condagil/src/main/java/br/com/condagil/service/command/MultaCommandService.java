package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.MultaBuilder;
import br.com.condagil.models.builder.MultaDTOBuilder;
import br.com.condagil.models.dto.MultaDTO;
import br.com.condagil.models.entity.Morador;
import br.com.condagil.models.entity.Multa;
import br.com.condagil.repository.command.MultaCommandRepository;
import br.com.condagil.repository.query.MoradorQueryRepository;

@Service
public class MultaCommandService {

	@Autowired
	private MultaCommandRepository multaCommandRepository;
	
	@Autowired
	private MoradorQueryRepository moradorQueryRepository;
	
	public MultaDTO salvarMulta(MultaDTO multaDTO) {
		Morador morador = moradorQueryRepository.recuperarMoradorPorId(multaDTO.getIdMorador());
		Multa entity = multaCommandRepository.salvarMulta(
			MultaBuilder.getInstance()
				.converterDTOEmMulta(multaDTO, morador)
				.idNull()
				.getMulta()
		);
		return MultaDTOBuilder
				.getInstance()
				.converterEntityEmMultaDTO(entity)
				.getMultaDTO();
	}
	
	public void deletarMulta(Long id) {
		multaCommandRepository.deletarMulta(id);
	}
	
	public MultaDTO atualizarMulta(MultaDTO multaDTO, Long id) {
		Multa multa = multaCommandRepository.recuperarMultaPorId(id);
		//multa.setDataOcorrencia(multaDTO.getDataOcorrencia());
		//multa.setDataPagamento(multaDTO.getDataPagamento());
		multa.setValor(multaDTO.getValor());
		multa.setMotivo(multaDTO.getMotivo());
		return MultaDTOBuilder
				.getInstance()
				.converterEntityEmMultaDTO(multaCommandRepository.atualizarMulta(multa))
				.getMultaDTO();
	}
	
}
