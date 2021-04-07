package br.com.condagil.models.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PontoFuncionarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("entrada")
	private String entrada;
	
	@JsonProperty("saida")
	private String saida;
	
	@JsonProperty("idFuncionario")
	private Long idFuncionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public LocalDateTime formatarEntradaLocalDateTime() {
		return LocalDate.parse(entrada, DateTimeFormatter.ofPattern("ddMMyyyy", Locale.US)).atStartOfDay();
	}
	
	public LocalDateTime formatarSaidaLocalDateTime() {
		return LocalDate.parse(saida, DateTimeFormatter.ofPattern("ddMMyyyy", Locale.US)).atStartOfDay();
	}
}