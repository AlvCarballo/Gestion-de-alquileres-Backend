package es.deepcode.gestionalquileres.fincas.model;

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
@Table(name="fincas")
public class Fincas implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8721876864947185642L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	@Column(length = 45)
	@JsonProperty("nombre_finca")
	private String nombre_finca;
	/**
	 * 
	 */
	/**
	 * @param nombre_finca
	 */
	public Fincas(String nombre_finca) {
		super();
		this.nombre_finca = nombre_finca;
	}
	/**
	 * @param id
	 * @param nombre_finca
	 */
	public Fincas(Long id, String nombre_finca) {
		super();
		this.id = id;
		this.nombre_finca = nombre_finca;
	}
	/**
	 * 
	 */
	public Fincas() {
		super();
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
	 * @return the nombre_finca
	 */
	public String getNombre_finca() {
		return nombre_finca;
	}
	/**
	 * @param nombre_finca the nombre_finca to set
	 */
	public void setNombre_finca(String nombre_finca) {
		this.nombre_finca = nombre_finca;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
