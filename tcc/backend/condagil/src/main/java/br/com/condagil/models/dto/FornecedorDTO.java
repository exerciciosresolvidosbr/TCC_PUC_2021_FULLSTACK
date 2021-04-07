package br.com.condagil.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FornecedorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("docIdentificacao")
	private String docIdentificacao;

	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("produtoServico")
	private String produtoServico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocIdentificacao() {
		return docIdentificacao;
	}

	public void setDocIdentificacao(String docIdentificacao) {
		this.docIdentificacao = docIdentificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProdutoServico() {
		return produtoServico;
	}

	public void setProdutoServico(String produtoServico) {
		this.produtoServico = produtoServico;
	}
}