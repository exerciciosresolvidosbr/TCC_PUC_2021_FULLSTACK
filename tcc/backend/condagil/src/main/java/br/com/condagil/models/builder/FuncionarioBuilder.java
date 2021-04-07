package br.com.condagil.models.builder;

import br.com.condagil.models.dto.FuncionarioDTO;
import br.com.condagil.models.entity.Funcionario;

public class FuncionarioBuilder {

	private Funcionario funcionario;
	
	private FuncionarioBuilder() {
		super();
		this.funcionario = new Funcionario();
	}
	
	public static FuncionarioBuilder getInstance() {
		return new FuncionarioBuilder();
	}

	public FuncionarioBuilder converterDTOEmFuncionario(FuncionarioDTO dto) {
		funcionario.setId(dto.getId());
		funcionario.setNome(dto.getNome());
		funcionario.setDataAdmissao(dto.formatarDataAdmissaoLocalDateTime());
		funcionario.setDataDemissao(dto.formatarDataDemissaoLocalDateTime());
		return this;
	}
	
	public FuncionarioBuilder idNull() {
		funcionario.setId(null);
		return this;
	}

	public FuncionarioBuilder replaceFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
		return this;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}	
}