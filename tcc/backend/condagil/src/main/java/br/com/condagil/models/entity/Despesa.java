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

@Entity
@Table(name="despesa")
public class Despesa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "data_despesa", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataDespesa;
	
	@Column(name = "valor")
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

	public LocalDateTime getDataDespesa() {
		return dataDespesa;
	}

	public void setDataDespesa(LocalDateTime dataDespesa) {
		this.dataDespesa = dataDespesa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}