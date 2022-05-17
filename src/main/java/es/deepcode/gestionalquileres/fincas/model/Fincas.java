package es.deepcode.gestionalquileres.fincas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
	private Long id;
	@Column(length = 45)
	private String nombreFinca;
	/**
	 * 
	 */
	
	/**
	 * @return the id
	 */
	public Long getid() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setid(Long id) {
		this.id = id;
	}
	/**
	 * @return the nombreFinca
	 */
	public String getNombreFinca() {
		return nombreFinca;
	}
	/**
	 * @param nombreFinca the nombreFinca to set
	 */
	public void setNombreFinca(String nombreFinca) {
		this.nombreFinca = nombreFinca;
	}
	/**
	 * @param id
	 * @param nombreFinca
	 */
	public Fincas(Long id, String nombreFinca) {
		super();
		this.id = id;
		this.nombreFinca = nombreFinca;
	}
	/**
	 * @param nombreFinca
	 */
	public Fincas(String nombreFinca) {
		super();
		this.nombreFinca = nombreFinca;
	}
	/**
	 * 
	 */
	public Fincas() {
		super();
	}
	
}
