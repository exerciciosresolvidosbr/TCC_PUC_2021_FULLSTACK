package br.com.condagil.exception;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

	private List<String> erros;

	public ApiErrors(List<String> erros) {
		super();
		this.erros = erros;
	}
	
	public ApiErrors(String message) {
		super();
		this.erros = Arrays.asList(message);
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
}
