package br.com.condagil.models.dto.oauth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class UsuarioLocalDTO extends User implements OAuth2User, OidcUser {

	private static final long serialVersionUID = -2845160792248762779L;
    private final OidcIdToken idToken;
    private final OidcUserInfo userInfo;
    private Map<String, Object> attributes;
    private UsuarioDTO usuarioDTO;
	
	public UsuarioLocalDTO(final String userID, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired,
            final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities, final UsuarioDTO usuarioDTO) {
        this(userID, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, usuarioDTO, null, null);
    }
 
    public UsuarioLocalDTO(final String userID, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired,
            final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities, final UsuarioDTO usuarioDTO, OidcIdToken idToken,
            OidcUserInfo userInfo) {
        super(userID, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.usuarioDTO = usuarioDTO;
        this.idToken = idToken;
        this.userInfo = userInfo;
    }
	
    public static UsuarioLocalDTO create(UsuarioDTO usuarioDTO, Map<String, Object> attributes, OidcIdToken idToken, OidcUserInfo userInfo) {
    	UsuarioLocalDTO usuarioLocalDTO = new UsuarioLocalDTO(usuarioDTO.getEmail(), usuarioDTO.getPassword(), usuarioDTO.getEnabled(), true, true, true, buildSimpleGrantedAuthorities(usuarioDTO.getRolesDTO()),
    			usuarioDTO, idToken, userInfo);
    	usuarioLocalDTO.setAttributes(attributes);
        return usuarioLocalDTO;
    }
    
	@Override
	public Map<String, Object> getAttributes() {
		return this.attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

	@Override
	public String getName() {
		return this.usuarioDTO.getDisplayName();
	}

	@Override
	public Map<String, Object> getClaims() {
		return this.attributes;
	}

	@Override
	public OidcUserInfo getUserInfo() {
		return this.userInfo;
	}

	@Override
	public OidcIdToken getIdToken() {
		return this.idToken;
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}
	
    public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Set<RoleDTO> rolesDTO) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleDTO roleDTO : rolesDTO) {
            authorities.add(new SimpleGrantedAuthority(roleDTO.getName()));
        }
        return authorities;
    }
}