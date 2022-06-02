/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author aocarballo
 *
 */
@Entity
@Table(name="propietarios")
public class Propietarios implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6096468201195133435L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	@JsonProperty("tipo_persona_propietario")
	private Boolean tipo_persona_propietario;
	@Column(length = 9)
	@JsonProperty("dni_propietario")
	private String dni_propietario;
	@Column(length = 45)
	@JsonProperty("nombre_propietario")
	private String nombre_propietario;
	@Column(length = 90)
	@JsonProperty("apellidos_propietario")
	private String apellidos_propietario;
	@Column(length = 45)
	@JsonProperty("tipo_via_propietario")
	private String tipo_via_propietario;
	@Column(length = 45)
	@JsonProperty("direccion_propietario")
	private String direccion_propietario;
	@JsonProperty("numero_propietario")
	private int numero_propietario;
	@Column(length = 45)
	@JsonProperty("piso_propietario")
	private String piso_propietario;
	@Column(length = 4)
	@JsonProperty("letra_propietario")
	private String letra_propietario;
	@Column(length = 24)
	@JsonProperty("cc_propietario")
	private String cc_propietario;
	@Column(length = 45)
	@JsonProperty("email_propietario")
	private String email_propietario;
	@JsonProperty("movil_propietario")
	private int movil_propietario;
	@JsonProperty("telefono_propietario")
	private int telefono_propietario;
	/**
	 * 
	 */
	public Propietarios() {
		super();
	}
	/**
	 * @param tipo_persona_propietario
	 * @param dni_propietario
	 * @param nombre_propietario
	 * @param apellidos_propietario
	 * @param tipo_via_propietario
	 * @param direccion_propietario
	 * @param numero_propietario
	 * @param piso_propietario
	 * @param letra_propietario
	 * @param cc_propietario
	 * @param email_propietario
	 * @param movil_propietario
	 * @param telefono_propietario
	 */
	public Propietarios(Boolean tipo_persona_propietario, String dni_propietario, String nombre_propietario,
			String apellidos_propietario, String tipo_via_propietario, String direccion_propietario,
			int numero_propietario, String piso_propietario, String letra_propietario, String cc_propietario,
			String email_propietario, int movil_propietario, int telefono_propietario) {
		super();
		this.tipo_persona_propietario = tipo_persona_propietario;
		this.dni_propietario = dni_propietario;
		this.nombre_propietario = nombre_propietario;
		this.apellidos_propietario = apellidos_propietario;
		this.tipo_via_propietario = tipo_via_propietario;
		this.direccion_propietario = direccion_propietario;
		this.numero_propietario = numero_propietario;
		this.piso_propietario = piso_propietario;
		this.letra_propietario = letra_propietario;
		this.cc_propietario = cc_propietario;
		this.email_propietario = email_propietario;
		this.movil_propietario = movil_propietario;
		this.telefono_propietario = telefono_propietario;
	}
	/**
	 * @param id
	 * @param tipo_persona_propietario
	 * @param dni_propietario
	 * @param nombre_propietario
	 * @param apellidos_propietario
	 * @param tipo_via_propietario
	 * @param direccion_propietario
	 * @param numero_propietario
	 * @param piso_propietario
	 * @param letra_propietario
	 * @param cc_propietario
	 * @param email_propietario
	 * @param movil_propietario
	 * @param telefono_propietario
	 */
	public Propietarios(Long id, Boolean tipo_persona_propietario, String dni_propietario, String nombre_propietario,
			String apellidos_propietario, String tipo_via_propietario, String direccion_propietario,
			int numero_propietario, String piso_propietario, String letra_propietario, String cc_propietario,
			String email_propietario, int movil_propietario, int telefono_propietario) {
		super();
		this.id = id;
		this.tipo_persona_propietario = tipo_persona_propietario;
		this.dni_propietario = dni_propietario;
		this.nombre_propietario = nombre_propietario;
		this.apellidos_propietario = apellidos_propietario;
		this.tipo_via_propietario = tipo_via_propietario;
		this.direccion_propietario = direccion_propietario;
		this.numero_propietario = numero_propietario;
		this.piso_propietario = piso_propietario;
		this.letra_propietario = letra_propietario;
		this.cc_propietario = cc_propietario;
		this.email_propietario = email_propietario;
		this.movil_propietario = movil_propietario;
		this.telefono_propietario = telefono_propietario;
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
	 * @return the tipo_persona_propietario
	 */
	public Boolean getTipo_persona_propietario() {
		return tipo_persona_propietario;
	}
	/**
	 * @param tipo_persona_propietario the tipo_persona_propietario to set
	 */
	public void setTipo_persona_propietario(Boolean tipo_persona_propietario) {
		this.tipo_persona_propietario = tipo_persona_propietario;
	}
	/**
	 * @return the dni_propietario
	 */
	public String getDni_propietario() {
		return dni_propietario;
	}
	/**
	 * @param dni_propietario the dni_propietario to set
	 */
	public void setDni_propietario(String dni_propietario) {
		this.dni_propietario = dni_propietario;
	}
	/**
	 * @return the nombre_propietario
	 */
	public String getNombre_propietario() {
		return nombre_propietario;
	}
	/**
	 * @param nombre_propietario the nombre_propietario to set
	 */
	public void setNombre_propietario(String nombre_propietario) {
		this.nombre_propietario = nombre_propietario;
	}
	/**
	 * @return the apellidos_propietario
	 */
	public String getApellidos_propietario() {
		return apellidos_propietario;
	}
	/**
	 * @param apellidos_propietario the apellidos_propietario to set
	 */
	public void setApellidos_propietario(String apellidos_propietario) {
		this.apellidos_propietario = apellidos_propietario;
	}
	/**
	 * @return the tipo_via_propietario
	 */
	public String getTipo_via_propietario() {
		return tipo_via_propietario;
	}
	/**
	 * @param tipo_via_propietario the tipo_via_propietario to set
	 */
	public void setTipo_via_propietario(String tipo_via_propietario) {
		this.tipo_via_propietario = tipo_via_propietario;
	}
	/**
	 * @return the direccion_propietario
	 */
	public String getDireccion_propietario() {
		return direccion_propietario;
	}
	/**
	 * @param direccion_propietario the direccion_propietario to set
	 */
	public void setDireccion_propietario(String direccion_propietario) {
		this.direccion_propietario = direccion_propietario;
	}
	/**
	 * @return the numero_propietario
	 */
	public int getNumero_propietario() {
		return numero_propietario;
	}
	/**
	 * @param numero_propietario the numero_propietario to set
	 */
	public void setNumero_propietario(int numero_propietario) {
		this.numero_propietario = numero_propietario;
	}
	/**
	 * @return the piso_propietario
	 */
	public String getPiso_propietario() {
		return piso_propietario;
	}
	/**
	 * @param piso_propietario the piso_propietario to set
	 */
	public void setPiso_propietario(String piso_propietario) {
		this.piso_propietario = piso_propietario;
	}
	/**
	 * @return the letra_propietario
	 */
	public String getLetra_propietario() {
		return letra_propietario;
	}
	/**
	 * @param letra_propietario the letra_propietario to set
	 */
	public void setLetra_propietario(String letra_propietario) {
		this.letra_propietario = letra_propietario;
	}
	/**
	 * @return the cc_propietario
	 */
	public String getCc_propietario() {
		return cc_propietario;
	}
	/**
	 * @param cc_propietario the cc_propietario to set
	 */
	public void setCc_propietario(String cc_propietario) {
		this.cc_propietario = cc_propietario;
	}
	/**
	 * @return the email_propietario
	 */
	public String getEmail_propietario() {
		return email_propietario;
	}
	/**
	 * @param email_propietario the email_propietario to set
	 */
	public void setEmail_propietario(String email_propietario) {
		this.email_propietario = email_propietario;
	}
	/**
	 * @return the movil_propietario
	 */
	public int getMovil_propietario() {
		return movil_propietario;
	}
	/**
	 * @param movil_propietario the movil_propietario to set
	 */
	public void setMovil_propietario(int movil_propietario) {
		this.movil_propietario = movil_propietario;
	}
	/**
	 * @return the telefono_propietario
	 */
	public int getTelefono_propietario() {
		return telefono_propietario;
	}
	/**
	 * @param telefono_propietario the telefono_propietario to set
	 */
	public void setTelefono_propietario(int telefono_propietario) {
		this.telefono_propietario = telefono_propietario;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
