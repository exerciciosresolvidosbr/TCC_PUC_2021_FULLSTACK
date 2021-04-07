package br.com.condagil.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DespesaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("descricao")
	private String descricao;
	
	@JsonProperty("dataDespesa")
	private String dataDespesaStr;
	
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

	public String getDataDespesaStr() {
		return dataDespesaStr;
	}

	public void setDataDespesaStr(String dataDespesaStr) {
		this.dataDespesaStr = dataDespesaStr;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
