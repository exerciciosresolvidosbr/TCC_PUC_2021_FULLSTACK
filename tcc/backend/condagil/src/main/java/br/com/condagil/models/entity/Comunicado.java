package br.com.condagil.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="comunicado")
public class Comunicado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@JsonProperty("dataValidade")
	@Column(name = "data_validade", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataValidade;
	
	@JsonProperty("texto")
	@NotNull
	@Column(name = "texto")
	private String texto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDateTime dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}