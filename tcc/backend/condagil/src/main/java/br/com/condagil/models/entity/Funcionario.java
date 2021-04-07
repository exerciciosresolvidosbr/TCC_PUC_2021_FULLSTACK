package br.com.condagil.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_admissao", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataAdmissao;
	
	@Column(name = "data_demissao", columnDefinition = "TIMESTAMP")
	private LocalDateTime dataDemissao;
	
	@OneToMany(mappedBy="funcionario")
    private Set<PontoFuncionario> pontosFuncionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDateTime getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDateTime dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Set<PontoFuncionario> getPontosFuncionario() {
		return pontosFuncionario;
	}

	public void setPontosFuncionario(Set<PontoFuncionario> pontosFuncionario) {
		this.pontosFuncionario = pontosFuncionario;
	}

}
