package br.com.condagil.models.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoradorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("cpf")
	private String cpf;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("identificacaoUnidadeHabitacional")
	private String identificacaoUnidadeHabitacional;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("telefone")
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdentificacaoUnidadeHabitacional() {
		return identificacaoUnidadeHabitacional;
	}

	public void setIdentificacaoUnidadeHabitacional(String identificacaoUnidadeHabitacional) {
		this.identificacaoUnidadeHabitacional = identificacaoUnidadeHabitacional;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}