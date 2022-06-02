/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.deepcode.gestionalquileres.fincas.model.Fincas;
import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;
import es.deepcode.gestionalquileres.propietarios.model.Propietarios;

/**
 * @author aocarballo
 *
 */
@Entity
@Table(name="inmueble")
public class Inmuebles implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3873855570574870795L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	@Column(length = 45)
	@JsonProperty("ref_catastral_inmueble")
	private String ref_catastral_inmueble;
	@Column(length = 45)
	@JsonProperty("piso_inmueble")
	private String piso_inmueble;
	@Column(length = 3)
	@JsonProperty("letra_inmueble")
	private String letra_inmueble;
	@JsonProperty("precio_inmueble")
	private double precio_inmueble;
	@JsonProperty("alquilado_inmueble")
	private boolean alquilado_inmueble;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_propietario", referencedColumnName="id")
	private Propietarios propietario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_finca", referencedColumnName="id")
	private Fincas finca;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_inquilino", referencedColumnName="id")
	private Inquilinos inquilino;

	/**
	 * 
	 */
	public Inmuebles() {
		super();
	}

	/**
	 * @param ref_catastral_inmueble
	 * @param piso_inmueble
	 * @param letra_inmueble
	 * @param propietario
	 * @param finca
	 * @param inquilino
	 */
	public Inmuebles(String ref_catastral_inmueble, String piso_inmueble, String letra_inmueble,
			Propietarios propietario, Fincas finca, Inquilinos inquilino) {
		super();
		this.ref_catastral_inmueble = ref_catastral_inmueble;
		this.piso_inmueble = piso_inmueble;
		this.letra_inmueble = letra_inmueble;
		this.propietario = propietario;
		this.finca = finca;
		this.inquilino = inquilino;
	}

	/**
	 * @param id
	 * @param ref_catastral_inmueble
	 * @param piso_inmueble
	 * @param letra_inmueble
	 * @param propietario
	 * @param finca
	 * @param inquilino
	 */
	public Inmuebles(Long id, String ref_catastral_inmueble, String piso_inmueble, String letra_inmueble,
			Propietarios propietario, Fincas finca, Inquilinos inquilino) {
		super();
		this.id = id;
		this.ref_catastral_inmueble = ref_catastral_inmueble;
		this.piso_inmueble = piso_inmueble;
		this.letra_inmueble = letra_inmueble;
		this.propietario = propietario;
		this.finca = finca;
		this.inquilino = inquilino;
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
	 * @return the ref_catastral_inmueble
	 */
	public String getRef_catastral_inmueble() {
		return ref_catastral_inmueble;
	}

	/**
	 * @param ref_catastral_inmueble the ref_catastral_inmueble to set
	 */
	public void setRef_catastral_inmueble(String ref_catastral_inmueble) {
		this.ref_catastral_inmueble = ref_catastral_inmueble;
	}

	/**
	 * @return the piso_inmueble
	 */
	public String getPiso_inmueble() {
		return piso_inmueble;
	}

	/**
	 * @param piso_inmueble the piso_inmueble to set
	 */
	public void setPiso_inmueble(String piso_inmueble) {
		this.piso_inmueble = piso_inmueble;
	}

	/**
	 * @return the letra_inmueble
	 */
	public String getLetra_inmueble() {
		return letra_inmueble;
	}

	/**
	 * @param letra_inmueble the letra_inmueble to set
	 */
	public void setLetra_inmueble(String letra_inmueble) {
		this.letra_inmueble = letra_inmueble;
	}

	/**
	 * @return the propietario
	 */
	public Propietarios getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(Propietarios propietario) {
		this.propietario = propietario;
	}

	/**
	 * @return the finca
	 */
	public Fincas getFinca() {
		return finca;
	}

	/**
	 * @param finca the finca to set
	 */
	public void setFinca(Fincas finca) {
		this.finca = finca;
	}

	/**
	 * @return the inquilino
	 */
	public Inquilinos getInquilino() {
		return inquilino;
	}

	/**
	 * @param inquilino the inquilino to set
	 */
	public void setInquilino(Inquilinos inquilino) {
		this.inquilino = inquilino;
	}

	/**
	 * @return the precio_inmueble
	 */
	public double getPrecio_inmueble() {
		return precio_inmueble;
	}

	/**
	 * @param precio_inmueble the precio_inmueble to set
	 */
	public void setPrecio_inmueble(double precio_inmueble) {
		this.precio_inmueble = precio_inmueble;
	}

	/**
	 * @return the alquilado_inmueble
	 */
	public boolean isAlquilado_inmueble() {
		return alquilado_inmueble;
	}

	/**
	 * @param alquilado_inmueble the alquilado_inmueble to set
	 */
	public void setAlquilado_inmueble(boolean alquilado_inmueble) {
		this.alquilado_inmueble = alquilado_inmueble;
	}
	
}
