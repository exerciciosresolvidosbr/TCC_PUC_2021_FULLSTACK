package br.com.condagil.models.dto.oauth;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("providerUserId")
	private String providerUserId;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("enabled")
	private boolean enabled;
	
	@JsonProperty("displayName")
	private String displayName;

	@JsonProperty("createdDate")
	private String createdDate;
	
	@JsonProperty("modifiedDate")
	private String modifiedDate;
	
	@JsonProperty("password")
    private String password;
 
	@JsonProperty("provider")
    private String provider;
	
	@JsonProperty("rolesDTO")
	private Set<RoleDTO> rolesDTO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Set<RoleDTO> getRolesDTO() {
		return rolesDTO;
	}

	public void setRolesDTO(Set<RoleDTO> rolesDTO) {
		this.rolesDTO = rolesDTO;
	}
}
