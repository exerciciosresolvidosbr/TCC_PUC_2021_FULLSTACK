package br.com.condagil.models.builder;

import br.com.condagil.models.dto.PontoFuncionarioDTO;
import br.com.condagil.models.entity.Funcionario;
import br.com.condagil.models.entity.PontoFuncionario;

public class PontoFuncionarioBuilder {

	private PontoFuncionario pontoFuncionario;

	private PontoFuncionarioBuilder() {
		super();
		this.pontoFuncionario = new PontoFuncionario();
	}
	
	public static PontoFuncionarioBuilder getInstance() {
		return new PontoFuncionarioBuilder();
	}
	
	public PontoFuncionarioBuilder converterDTOEmPontoFuncionario(PontoFuncionarioDTO dto) {
		pontoFuncionario.setId(dto.getId());
		pontoFuncionario.setEntrada(dto.formatarEntradaLocalDateTime());
		pontoFuncionario.setSaida(dto.formatarSaidaLocalDateTime());
		return this;
	}
	
	public PontoFuncionarioBuilder idNull() {
		pontoFuncionario.setId(null);
		return this;
	}

	public PontoFuncionarioBuilder addFuncionario(Funcionario funcionario) {
		pontoFuncionario.setFuncionario(funcionario);
		return this;
	}
	
	public PontoFuncionario getPontoFuncionario() {
		return pontoFuncionario;
	}	
}
