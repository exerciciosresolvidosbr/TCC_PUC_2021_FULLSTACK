package br.com.condagil.models.dto.oauth;

public class JwtAuthenticationResponse {

	private String accessToken;
    
	private UsuarioDTO usuarioDTO;
	
	public JwtAuthenticationResponse() {
		super();
	}

	public JwtAuthenticationResponse(String accessToken, UsuarioDTO usuarioDTO) {
		super();
		this.accessToken = accessToken;
		this.usuarioDTO = usuarioDTO;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
    
}