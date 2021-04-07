package br.com.condagil.models.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.condagil.models.dto.ComunicadoDTO;
import br.com.condagil.models.entity.Comunicado;

public class ComunicadoDTOBuilder {

	private ComunicadoDTO comunicadoDTO;
	
	private ComunicadoDTOBuilder() {
		super();
		this.comunicadoDTO = new ComunicadoDTO();
	}
	
	public static ComunicadoDTOBuilder getInstance() {
		return new ComunicadoDTOBuilder();
	}
	
	public ComunicadoDTOBuilder converterEntityEmComunicadoDTO(Comunicado entity) {
		comunicadoDTO.setId(entity.getId());
		//comunicadoDTO.setDataValidadeStr(entity.getDataValidade());
		comunicadoDTO.setTexto(entity.getTexto());
		return this;
	}
	
	public static List<ComunicadoDTO> converterListaEntityEmComunicadoDTO(List<Comunicado> listaEntity) {
		List<ComunicadoDTO> listaComunicadosDTO = new ArrayList<ComunicadoDTO>();
		listaEntity.forEach(entity->{
			listaComunicadosDTO.add(
				ComunicadoDTOBuilder.getInstance()
					.converterEntityEmComunicadoDTO(entity)
					.getComunicadoDTO()
			);
		});
		return listaComunicadosDTO;
	}

	public ComunicadoDTO getComunicadoDTO() {
		return comunicadoDTO;
	}
}