package br.com.condagil.models.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.condagil.models.dto.MultaDTO;
import br.com.condagil.models.entity.Multa;

public class MultaDTOBuilder {

	private MultaDTO multaDTO;

	private MultaDTOBuilder() {
		super();
		this.multaDTO = new MultaDTO();
	}
	
	public static MultaDTOBuilder getInstance() {
		return new MultaDTOBuilder();
	}
	
	public MultaDTOBuilder converterEntityEmMultaDTO(Multa entity) {
		multaDTO.setId(entity.getId());
		//multaDTO.setDataOcorrencia(entity.getDataOcorrencia());
		//multaDTO.setDataPagamento(entity.getDataPagamento());
		multaDTO.setMotivo(entity.getMotivo());
		multaDTO.setValor(entity.getValor());
		multaDTO.setMorador(
			MoradorDTOBuilder
				.getInstance()
				.converterEntityEmMoradorDTO(entity.getMorador())
				.getMoradorDTO()
		);
		return this;
	}
	
	public static List<MultaDTO> converterListaEntityEmMultaDTO(List<Multa> listaEntity) {
		List<MultaDTO> listaMultaDTO = new ArrayList<MultaDTO>();
		listaEntity.forEach(entity->{
			listaMultaDTO.add(
				MultaDTOBuilder.getInstance()
					.converterEntityEmMultaDTO(entity)
					.getMultaDTO()
			);
		});
		return listaMultaDTO;
	}

	public MultaDTO getMultaDTO() {
		return multaDTO;
	}
}