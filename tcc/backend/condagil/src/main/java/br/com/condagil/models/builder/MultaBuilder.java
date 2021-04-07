package br.com.condagil.models.builder;

import br.com.condagil.models.dto.MultaDTO;
import br.com.condagil.models.entity.Morador;
import br.com.condagil.models.entity.Multa;

public class MultaBuilder {

	private Multa multa;

	private MultaBuilder() {
		super();
		this.multa = new Multa();
	}
	
	public static MultaBuilder getInstance() {
		return new MultaBuilder();
	}
	
	public MultaBuilder converterDTOEmMulta(MultaDTO dto, Morador morador) {
		multa.setId(dto.getId());
		//multa.setDataOcorrencia(dto.getDataOcorrencia());
		//multa.setDataPagamento(dto.getDataPagamento());
		multa.setMotivo(dto.getMotivo());
		multa.setValor(dto.getValor());
		multa.setMorador(morador);
		return this;
	}
	
	public MultaBuilder idNull() {
		multa.setId(null);
		return this;
	}

	public Multa getMulta() {
		return multa;
	}	
}