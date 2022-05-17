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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	private Long id;
	@Column(length = 45)
	private String RefCatastralInmueble;
	@Column(length = 45)
	private String pisoInmueble;
	@Column(length = 3)
	private String letraInmueble;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Propietarios propietario;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Fincas finca;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Inquilinos inquilino;

	/**
	 * 
	 */
	public Inmuebles() {
		super();
	}

	/**
	 * @param id
	 * @param refCatastralInmueble
	 * @param pisoInmueble
	 * @param letraInmueble
	 * @param propietario
	 * @param finca
	 * @param inquilino
	 */
	public Inmuebles(Long id, String refCatastralInmueble, String pisoInmueble, String letraInmueble,
			Propietarios propietario, Fincas finca, Inquilinos inquilino) {
		super();
		this.id = id;
		RefCatastralInmueble = refCatastralInmueble;
		this.pisoInmueble = pisoInmueble;
		this.letraInmueble = letraInmueble;
		this.propietario = propietario;
		this.finca = finca;
		this.inquilino = inquilino;
	}

	/**
	 * @param refCatastralInmueble
	 * @param pisoInmueble
	 * @param letraInmueble
	 * @param propietario
	 * @param finca
	 * @param inquilino
	 */
	public Inmuebles(String refCatastralInmueble, String pisoInmueble, String letraInmueble, Propietarios propietario,
			Fincas finca, Inquilinos inquilino) {
		super();
		RefCatastralInmueble = refCatastralInmueble;
		this.pisoInmueble = pisoInmueble;
		this.letraInmueble = letraInmueble;
		this.propietario = propietario;
		this.finca = finca;
		this.inquilino = inquilino;
	}

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
	 * @return the refCatastralInmueble
	 */
	public String getRefCatastralInmueble() {
		return RefCatastralInmueble;
	}

	/**
	 * @param refCatastralInmueble the refCatastralInmueble to set
	 */
	public void setRefCatastralInmueble(String refCatastralInmueble) {
		RefCatastralInmueble = refCatastralInmueble;
	}

	/**
	 * @return the pisoInmueble
	 */
	public String getPisoInmueble() {
		return pisoInmueble;
	}

	/**
	 * @param pisoInmueble the pisoInmueble to set
	 */
	public void setPisoInmueble(String pisoInmueble) {
		this.pisoInmueble = pisoInmueble;
	}

	/**
	 * @return the letraInmueble
	 */
	public String getLetraInmueble() {
		return letraInmueble;
	}

	/**
	 * @param letraInmueble the letraInmueble to set
	 */
	public void setLetraInmueble(String letraInmueble) {
		this.letraInmueble = letraInmueble;
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
	
	
}
