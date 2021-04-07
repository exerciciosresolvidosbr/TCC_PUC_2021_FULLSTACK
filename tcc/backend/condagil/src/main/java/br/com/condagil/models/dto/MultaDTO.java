package br.com.condagil.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MultaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("motivo")
	private String motivo;
	
	@JsonProperty("dataOcorrencia")
	private String dataOcorrencia;
	
	@JsonProperty("dataPagamento")
	private String dataPagamento;
	
	@JsonProperty("valor")
	private Double valor;

	//Insert e Update
	@JsonProperty("idMorador")
	private Long idMorador;
	
	//Listagem
	@JsonProperty("morador")
	private MoradorDTO morador;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(String dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getIdMorador() {
		return idMorador;
	}

	public void setIdMorador(Long idMorador) {
		this.idMorador = idMorador;
	}

	public MoradorDTO getMorador() {
		return morador;
	}

	public void setMorador(MoradorDTO morador) {
		this.morador = morador;
	}
}