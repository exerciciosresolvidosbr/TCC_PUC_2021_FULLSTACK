package br.com.condagil.models.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FuncionarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("dataAdmissao")
	private String dataAdmissao;
	
	@JsonProperty("dataDemissao")
	private String dataDemissao;
	
	@JsonProperty("pontosFuncionarioDTO")
    private Set<PontoFuncionarioDTO> pontosFuncionarioDTO;

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

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(String dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Set<PontoFuncionarioDTO> getPontosFuncionarioDTO() {
		return pontosFuncionarioDTO;
	}

	public void setPontosFuncionarioDTO(Set<PontoFuncionarioDTO> pontosFuncionarioDTO) {
		this.pontosFuncionarioDTO = pontosFuncionarioDTO;
	}
	
	public LocalDateTime formatarDataAdmissaoLocalDateTime() {
		return LocalDate.parse(dataAdmissao, DateTimeFormatter.ofPattern("ddMMyyyy", Locale.US)).atStartOfDay();
	}
	
	public LocalDateTime formatarDataDemissaoLocalDateTime() {
		return LocalDate.parse(dataDemissao, DateTimeFormatter.ofPattern("ddMMyyyy", Locale.US)).atStartOfDay();
	}
}
