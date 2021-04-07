package br.com.condagil.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class AppControllerAdvice {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException(ResponseStatusException ex) {
		ApiErrors apiErrors = new ApiErrors(ex.getMessage());
		return new ResponseEntity(apiErrors, ex.getStatus());
	}
	
}
