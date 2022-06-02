/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.model;

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
@Table(name="inquilinos")
public class Inquilinos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2580139428569705764L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	@Column(length = 9)
	@JsonProperty("dni_inquilino")
	private String dni_inquilino;
	@Column(length = 45)
	@JsonProperty("nombre_inquilino")
	private String nombre_inquilino;
	@Column(length = 90)
	@JsonProperty("apellidos_inquilino")
	private String apellidos_inquilino;
	@Column(length = 45)
	@JsonProperty("tipo_via_inquilino")
	private String tipo_via_inquilino;
	@Column(length = 45)
	@JsonProperty("direccion_inquilino")
	private String direccion_inquilino;
	@JsonProperty("numero_inquilino")
	private int numero_inquilino;
	@Column(length = 45)
	@JsonProperty("piso_inquilino")
	private String piso_inquilino;
	@Column(length = 4)
	@JsonProperty("letra_inquilino")
	private String letra_inquilino;
	@Column(length = 24)
	@JsonProperty("cc_inquilino")
	private String cc_inquilino;
	@Column(length = 45)
	@JsonProperty("email_inquilino")
	private String email_inquilino;
	@JsonProperty("movil_inquilino")
	private int movil_inquilino;
	@JsonProperty("telefono_inquilino")
	private int telefono_inquilino;
	/**
	 * 
	 */
	public Inquilinos() {
		super();
	}
	/**
	 * @param dni_inquilino
	 * @param nombre_inquilino
	 * @param apellidos_inquilino
	 * @param tipo_via_inquilino
	 * @param direccion_inquilino
	 * @param numero_inquilino
	 * @param piso_inquilino
	 * @param letra_inquilino
	 * @param cc_inquilino
	 * @param email_inquilino
	 * @param movil_inquilino
	 * @param telefono_inquilino
	 */
	public Inquilinos(String dni_inquilino, String nombre_inquilino, String apellidos_inquilino,
			String tipo_via_inquilino, String direccion_inquilino, int numero_inquilino, String piso_inquilino,
			String letra_inquilino, String cc_inquilino, String email_inquilino, int movil_inquilino,
			int telefono_inquilino) {
		super();
		this.dni_inquilino = dni_inquilino;
		this.nombre_inquilino = nombre_inquilino;
		this.apellidos_inquilino = apellidos_inquilino;
		this.tipo_via_inquilino = tipo_via_inquilino;
		this.direccion_inquilino = direccion_inquilino;
		this.numero_inquilino = numero_inquilino;
		this.piso_inquilino = piso_inquilino;
		this.letra_inquilino = letra_inquilino;
		this.cc_inquilino = cc_inquilino;
		this.email_inquilino = email_inquilino;
		this.movil_inquilino = movil_inquilino;
		this.telefono_inquilino = telefono_inquilino;
	}
	/**
	 * @param id
	 * @param dni_inquilino
	 * @param nombre_inquilino
	 * @param apellidos_inquilino
	 * @param tipo_via_inquilino
	 * @param direccion_inquilino
	 * @param numero_inquilino
	 * @param piso_inquilino
	 * @param letra_inquilino
	 * @param cc_inquilino
	 * @param email_inquilino
	 * @param movil_inquilino
	 * @param telefono_inquilino
	 */
	public Inquilinos(Long id, String dni_inquilino, String nombre_inquilino, String apellidos_inquilino,
			String tipo_via_inquilino, String direccion_inquilino, int numero_inquilino, String piso_inquilino,
			String letra_inquilino, String cc_inquilino, String email_inquilino, int movil_inquilino,
			int telefono_inquilino) {
		super();
		this.id = id;
		this.dni_inquilino = dni_inquilino;
		this.nombre_inquilino = nombre_inquilino;
		this.apellidos_inquilino = apellidos_inquilino;
		this.tipo_via_inquilino = tipo_via_inquilino;
		this.direccion_inquilino = direccion_inquilino;
		this.numero_inquilino = numero_inquilino;
		this.piso_inquilino = piso_inquilino;
		this.letra_inquilino = letra_inquilino;
		this.cc_inquilino = cc_inquilino;
		this.email_inquilino = email_inquilino;
		this.movil_inquilino = movil_inquilino;
		this.telefono_inquilino = telefono_inquilino;
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
	 * @return the dni_inquilino
	 */
	public String getDni_inquilino() {
		return dni_inquilino;
	}
	/**
	 * @param dni_inquilino the dni_inquilino to set
	 */
	public void setDni_inquilino(String dni_inquilino) {
		this.dni_inquilino = dni_inquilino;
	}
	/**
	 * @return the nombre_inquilino
	 */
	public String getNombre_inquilino() {
		return nombre_inquilino;
	}
	/**
	 * @param nombre_inquilino the nombre_inquilino to set
	 */
	public void setNombre_inquilino(String nombre_inquilino) {
		this.nombre_inquilino = nombre_inquilino;
	}
	/**
	 * @return the apellidos_inquilino
	 */
	public String getApellidos_inquilino() {
		return apellidos_inquilino;
	}
	/**
	 * @param apellidos_inquilino the apellidos_inquilino to set
	 */
	public void setApellidos_inquilino(String apellidos_inquilino) {
		this.apellidos_inquilino = apellidos_inquilino;
	}
	/**
	 * @return the tipo_via_inquilino
	 */
	public String getTipo_via_inquilino() {
		return tipo_via_inquilino;
	}
	/**
	 * @param tipo_via_inquilino the tipo_via_inquilino to set
	 */
	public void setTipo_via_inquilino(String tipo_via_inquilino) {
		this.tipo_via_inquilino = tipo_via_inquilino;
	}
	/**
	 * @return the direccion_inquilino
	 */
	public String getDireccion_inquilino() {
		return direccion_inquilino;
	}
	/**
	 * @param direccion_inquilino the direccion_inquilino to set
	 */
	public void setDireccion_inquilino(String direccion_inquilino) {
		this.direccion_inquilino = direccion_inquilino;
	}
	/**
	 * @return the numero_inquilino
	 */
	public int getNumero_inquilino() {
		return numero_inquilino;
	}
	/**
	 * @param numero_inquilino the numero_inquilino to set
	 */
	public void setNumero_inquilino(int numero_inquilino) {
		this.numero_inquilino = numero_inquilino;
	}
	/**
	 * @return the piso_inquilino
	 */
	public String getPiso_inquilino() {
		return piso_inquilino;
	}
	/**
	 * @param piso_inquilino the piso_inquilino to set
	 */
	public void setPiso_inquilino(String piso_inquilino) {
		this.piso_inquilino = piso_inquilino;
	}
	/**
	 * @return the letra_inquilino
	 */
	public String getLetra_inquilino() {
		return letra_inquilino;
	}
	/**
	 * @param letra_inquilino the letra_inquilino to set
	 */
	public void setLetra_inquilino(String letra_inquilino) {
		this.letra_inquilino = letra_inquilino;
	}
	/**
	 * @return the cc_inquilino
	 */
	public String getCc_inquilino() {
		return cc_inquilino;
	}
	/**
	 * @param cc_inquilino the cc_inquilino to set
	 */
	public void setCc_inquilino(String cc_inquilino) {
		this.cc_inquilino = cc_inquilino;
	}
	/**
	 * @return the email_inquilino
	 */
	public String getEmail_inquilino() {
		return email_inquilino;
	}
	/**
	 * @param email_inquilino the email_inquilino to set
	 */
	public void setEmail_inquilino(String email_inquilino) {
		this.email_inquilino = email_inquilino;
	}
	/**
	 * @return the movil_inquilino
	 */
	public int getMovil_inquilino() {
		return movil_inquilino;
	}
	/**
	 * @param movil_inquilino the movil_inquilino to set
	 */
	public void setMovil_inquilino(int movil_inquilino) {
		this.movil_inquilino = movil_inquilino;
	}
	/**
	 * @return the telefono_inquilino
	 */
	public int getTelefono_inquilino() {
		return telefono_inquilino;
	}
	/**
	 * @param telefono_inquilino the telefono_inquilino to set
	 */
	public void setTelefono_inquilino(int telefono_inquilino) {
		this.telefono_inquilino = telefono_inquilino;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
