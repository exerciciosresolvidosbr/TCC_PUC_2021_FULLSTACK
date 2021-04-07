package br.com.condagil.models.builder;

import br.com.condagil.models.dto.ComunicadoDTO;
import br.com.condagil.models.entity.Comunicado;

public class ComunicadoBuilder {

	private Comunicado comunicado;

	private ComunicadoBuilder() {
		super();
		this.comunicado = new Comunicado();
	}
	
	public static ComunicadoBuilder getInstance() {
		return new ComunicadoBuilder();
	}
	
	public ComunicadoBuilder converterDTOEmComunicado(ComunicadoDTO dto) {
		comunicado.setId(dto.getId());
		//comunicado.setDataValidade(dto.getDataValidade());
		comunicado.setTexto(dto.getTexto());
		return this;
	}
	
	public ComunicadoBuilder idNull() {
		comunicado.setId(null);
		return this;
	}

	public Comunicado getComunicado() {
		return comunicado;
	}	
}