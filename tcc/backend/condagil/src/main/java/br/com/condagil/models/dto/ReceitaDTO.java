package br.com.condagil.models.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceitaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("dataReceita")
	private String dataReceita;
	
	@JsonProperty("valor")
	private Double valor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(String dataReceita) {
		this.dataReceita = dataReceita;
	}

	public LocalDateTime formatarDataReceitaLocalDateTime() {
		return LocalDate.parse(dataReceita, DateTimeFormatter.ofPattern("ddMMyyyy", Locale.US)).atStartOfDay();
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}