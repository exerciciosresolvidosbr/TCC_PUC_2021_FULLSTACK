package br.com.condagil.models.builder;

import br.com.condagil.models.dto.FornecedorDTO;
import br.com.condagil.models.entity.Fornecedor;

public class FornecedorBuilder {

	private Fornecedor fornecedor;

	private FornecedorBuilder() {
		super();
		this.fornecedor = new Fornecedor();
	}
	
	public static FornecedorBuilder getInstance() {
		return new FornecedorBuilder();
	}
	
	public FornecedorBuilder converterDTOEmFornecedor(FornecedorDTO dto) {
		fornecedor.setId(dto.getId());
		fornecedor.setDocIdentificacao(dto.getDocIdentificacao());
		fornecedor.setNome(dto.getNome());
		fornecedor.setProdutoServico(dto.getProdutoServico());
		return this;
	}
	
	public FornecedorBuilder idNull() {
		fornecedor.setId(null);
		return this;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}
}