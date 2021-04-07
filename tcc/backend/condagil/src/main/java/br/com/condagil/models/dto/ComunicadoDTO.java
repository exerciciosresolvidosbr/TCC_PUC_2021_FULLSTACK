package br.com.condagil.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ComunicadoDTO {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("texto")
	private String texto;
	
	@JsonProperty("dataValidade")
	private String dataValidadeStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getDataValidadeStr() {
		return dataValidadeStr;
	}

	public void setDataValidadeStr(String dataValidadeStr) {
		this.dataValidadeStr = dataValidadeStr;
	}
}