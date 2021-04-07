package br.com.condagil.models.entity.oauth;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable {
	
	    private static final long serialVersionUID = 1L;
	    
	    public static final String MORADOR = "MORADOR";
	    public static final String SINDICO = "SINDICO";
	    public static final String FUNCIONARIO = "FUNCIONARIO";
	    public static final String ADMIN = "ADMIN";
	 
	    @Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;
	 
	    @Column(name = "name")
	    private String name;
	 
	    // bi-directional many-to-many association to User
	    @ManyToMany(mappedBy = "roles")
	    private Set<Usuario> usuarios;
	 
	    public Role() {
			super();
		}

		public Role(String name) {
	        this.name = name;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public Set<Usuario> getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(Set<Usuario> usuarios) {
			this.usuarios = usuarios;
		}

		@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        return result;
	    }
	 
	    @Override
	    public boolean equals(final Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Role role = (Role) obj;
	        if (!role.name.equals(role.name)) {
	            return false;
	        }
	        return true;
	    }
	 
	    @Override
	    public String toString() {
	        final StringBuilder builder = new StringBuilder();
	        builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
	        return builder.toString();
	    }
	
}