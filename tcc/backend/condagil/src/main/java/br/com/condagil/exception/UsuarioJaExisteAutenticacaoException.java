package br.com.condagil.exception;

import org.springframework.security.core.AuthenticationException;

public class UsuarioJaExisteAutenticacaoException extends AuthenticationException {
 
    private static final long serialVersionUID = 5570981880007077317L;
 
    public UsuarioJaExisteAutenticacaoException(final String msg) {
        super(msg);
    }

}
