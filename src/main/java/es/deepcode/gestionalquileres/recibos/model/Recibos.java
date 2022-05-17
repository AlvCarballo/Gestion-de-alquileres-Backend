/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;
import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;

/**
 * @author aocarballo
 *
 */
@Entity
@Table(name="recibos")
public class Recibos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2061500905734504316L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double importeRecibo;
	@Column(length = 45)
	private String conceptoRecibo;
	private Date fechaRecibo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Inquilinos inquilino;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Inmuebles inmueble;
	/**
	 * 
	 */
	public Recibos() {
		super();
	}
	/**
	 * @param importeRecibo
	 * @param conceptoRecibo
	 * @param fechaRecibo
	 * @param inquilino
	 * @param inmueble
	 */
	public Recibos(Double importeRecibo, String conceptoRecibo, Date fechaRecibo, Inquilinos inquilino,
			Inmuebles inmueble) {
		super();
		this.importeRecibo = importeRecibo;
		this.conceptoRecibo = conceptoRecibo;
		this.fechaRecibo = fechaRecibo;
		this.inquilino = inquilino;
		this.inmueble = inmueble;
	}
	/**
	 * @param id
	 * @param importeRecibo
	 * @param conceptoRecibo
	 * @param fechaRecibo
	 * @param inquilino
	 * @param inmueble
	 */
	public Recibos(Long id, Double importeRecibo, String conceptoRecibo, Date fechaRecibo, Inquilinos inquilino,
			Inmuebles inmueble) {
		super();
		this.id = id;
		this.importeRecibo = importeRecibo;
		this.conceptoRecibo = conceptoRecibo;
		this.fechaRecibo = fechaRecibo;
		this.inquilino = inquilino;
		this.inmueble = inmueble;
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
	 * @return the importeRecibo
	 */
	public Double getImporteRecibo() {
		return importeRecibo;
	}
	/**
	 * @param importeRecibo the importeRecibo to set
	 */
	public void setImporteRecibo(Double importeRecibo) {
		this.importeRecibo = importeRecibo;
	}
	/**
	 * @return the conceptoRecibo
	 */
	public String getConceptoRecibo() {
		return conceptoRecibo;
	}
	/**
	 * @param conceptoRecibo the conceptoRecibo to set
	 */
	public void setConceptoRecibo(String conceptoRecibo) {
		this.conceptoRecibo = conceptoRecibo;
	}
	/**
	 * @return the fechaRecibo
	 */
	public Date getFechaRecibo() {
		return fechaRecibo;
	}
	/**
	 * @param fechaRecibo the fechaRecibo to set
	 */
	public void setFechaRecibo(Date fechaRecibo) {
		this.fechaRecibo = fechaRecibo;
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
	 * @return the inmueble
	 */
	public Inmuebles getInmueble() {
		return inmueble;
	}
	/**
	 * @param inmueble the inmueble to set
	 */
	public void setInmueble(Inmuebles inmueble) {
		this.inmueble = inmueble;
	}
	
}
