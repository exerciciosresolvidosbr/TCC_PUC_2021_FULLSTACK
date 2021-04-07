package br.com.condagil.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.condagil.models.builder.ComunicadoBuilder;
import br.com.condagil.models.builder.ComunicadoDTOBuilder;
import br.com.condagil.models.dto.ComunicadoDTO;
import br.com.condagil.models.entity.Comunicado;
import br.com.condagil.repository.command.ComunicadoCommandRepository;

@Service
public class ComunicadoCommandService {

	@Autowired
	private ComunicadoCommandRepository comunicadoCommandRepository;
	
	public ComunicadoDTO salvarComunicado(ComunicadoDTO ComunicadoDTO) {
		Comunicado entity = comunicadoCommandRepository.salvarComunicado(
			ComunicadoBuilder.getInstance()
				.converterDTOEmComunicado(ComunicadoDTO)
				.idNull()
				.getComunicado()
		);
		return ComunicadoDTOBuilder
				.getInstance()
				.converterEntityEmComunicadoDTO(entity)
				.getComunicadoDTO();
	}
	
	public void deletarComunicado(Long id) {
		comunicadoCommandRepository.deletarComunicado(id);
	}
	
	public ComunicadoDTO atualizarComunicado(ComunicadoDTO comunicadoDTO, Long id) {
		Comunicado Comunicado = comunicadoCommandRepository.recuperarComunicadoPorId(id);
		//Comunicado.setDataComunicado(comunicadoDTO.getDataComunicadoStr());
		Comunicado.setTexto(comunicadoDTO.getTexto());
		return ComunicadoDTOBuilder
				.getInstance()
				.converterEntityEmComunicadoDTO(comunicadoCommandRepository.atualizarComunicado(Comunicado))
				.getComunicadoDTO();
	}
	
}
