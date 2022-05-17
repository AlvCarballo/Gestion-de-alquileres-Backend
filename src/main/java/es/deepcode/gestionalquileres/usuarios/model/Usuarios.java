/**
 * 
 */
package es.deepcode.gestionalquileres.usuarios.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author aocarballo
 *
 */
@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6926140715861758949L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true, length = 45)
	private String nombreUsuario;
	@Column(length = 256)
	private String pwdUsuario;
	private Boolean usuarioHabilitado;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="usuarios_roles",
	joinColumns= @JoinColumn(name="usuarios_id"),
	inverseJoinColumns=@JoinColumn(name="roles_id"),
	uniqueConstraints= {@UniqueConstraint(columnNames = {"usuarios_id","roles_id"})})
	private List<Roles> roles;
	/**
	 * 
	 */
	public Usuarios() {
		super();
	}
	/**
	 * @param nombreUsuario
	 * @param pwdUsuario
	 * @param usuarioHabilitado
	 * @param roles
	 */
	public Usuarios(String nombreUsuario, String pwdUsuario, Boolean usuarioHabilitado, List<Roles> roles) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.pwdUsuario = pwdUsuario;
		this.usuarioHabilitado = usuarioHabilitado;
		this.roles = roles;
	}
	/**
	 * @param id
	 * @param nombreUsuario
	 * @param pwdUsuario
	 * @param usuarioHabilitado
	 * @param roles
	 */
	public Usuarios(Long id, String nombreUsuario, String pwdUsuario, Boolean usuarioHabilitado, List<Roles> roles) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.pwdUsuario = pwdUsuario;
		this.usuarioHabilitado = usuarioHabilitado;
		this.roles = roles;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * @return the pwdUsuario
	 */
	public String getPwdUsuario() {
		return pwdUsuario;
	}
	/**
	 * @param pwdUsuario the pwdUsuario to set
	 */
	public void setPwdUsuario(String pwdUsuario) {
		this.pwdUsuario = pwdUsuario;
	}
	/**
	 * @return the usuarioHabilitado
	 */
	public Boolean getUsuarioHabilitado() {
		return usuarioHabilitado;
	}
	/**
	 * @param usuarioHabilitado the usuarioHabilitado to set
	 */
	public void setUsuarioHabilitado(Boolean usuarioHabilitado) {
		this.usuarioHabilitado = usuarioHabilitado;
	}
	/**
	 * @return the roles
	 */
	public List<Roles> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
}
