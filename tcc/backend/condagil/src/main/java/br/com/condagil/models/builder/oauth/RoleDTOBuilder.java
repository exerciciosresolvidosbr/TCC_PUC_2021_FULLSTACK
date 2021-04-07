package br.com.condagil.models.builder.oauth;

import java.util.HashSet;
import java.util.Set;

import br.com.condagil.models.dto.oauth.RoleDTO;
import br.com.condagil.models.entity.oauth.Role;

public class RoleDTOBuilder {

	private RoleDTO roleDTO;

	private RoleDTOBuilder() {
		super();
		this.roleDTO = new RoleDTO();
	}
	
	public static RoleDTOBuilder getInstance() {
		return new RoleDTOBuilder();
	}
	
	public RoleDTOBuilder converterEntityEmRoleDTO(Role entity) {		
		roleDTO.setId(entity.getId());
		roleDTO.setName(entity.getName());
		return this;
	}
	
	public static Set<RoleDTO> converterListaEntityEmRoleDTO(Set<Role> listaEntity) {
		Set<RoleDTO> listaRolesDTO = new HashSet<RoleDTO>();
		listaEntity.forEach(entity->{
			listaRolesDTO.add(
				RoleDTOBuilder.getInstance()
					.converterEntityEmRoleDTO(entity)
					.getRoleDTO()
			);
		});
		return listaRolesDTO;
	}

	public RoleDTO getRoleDTO() {
		return roleDTO;
	}
	
}