package br.com.condagil.service.oauth;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.condagil.models.dto.oauth.RoleDTO;
import br.com.condagil.models.dto.oauth.UsuarioDTO;
import br.com.condagil.models.dto.oauth.UsuarioLocalDTO;

@Service("usuarioLocalService")
public class UsuarioLocalService implements UserDetailsService {

	@Autowired
    private UsuarioQueryService usuarioQueryService;
 
	@Override
    @Transactional
    public UsuarioLocalDTO loadUserByUsername(final String email) throws UsernameNotFoundException {
        UsuarioDTO usuarioDTO = usuarioQueryService.recuperarPorEmail(email);
        if (usuarioDTO == null) {
            throw new UsernameNotFoundException("User " + email + " was not found in the database");
        }
        return createUsuarioLocalDTO(usuarioDTO);
    }
 
    @Transactional
    public UsuarioLocalDTO loadUserById(Long id) {
    	UsuarioDTO usuarioDTO = usuarioQueryService.recuperarUsuarioPorId(id);
        return createUsuarioLocalDTO(usuarioDTO);
    }
 
    /**
     * @param user
     * @return
     */
    private UsuarioLocalDTO createUsuarioLocalDTO(UsuarioDTO usuarioDTO) {
        return new UsuarioLocalDTO(usuarioDTO.getEmail(), usuarioDTO.getPassword(), usuarioDTO.getEnabled(), true, true, true, buildSimpleGrantedAuthorities(usuarioDTO.getRolesDTO()), usuarioDTO);
    }
    
    public static List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final Set<RoleDTO> rolesDTO) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleDTO roleDTO : rolesDTO) {
            authorities.add(new SimpleGrantedAuthority(roleDTO.getName()));
        }
        return authorities;
    }
}
