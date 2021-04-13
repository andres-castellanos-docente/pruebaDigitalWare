package co.prueba.digitalware.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuariosrest database table.
 * 
 */
@Entity
@Table(name="usuariosrest")
@NamedQuery(name="Usuariosrest.findAll", query="SELECT u FROM UsuariosrestEntity u")
public class UsuariosrestEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String username;
	@Column(name="activo")
	private boolean activo;


	public UsuariosrestEntity() {
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
