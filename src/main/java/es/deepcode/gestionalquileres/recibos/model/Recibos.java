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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("id")
	private Long id;
	@JsonProperty("importe_recibo")
	private Double importe_recibo;
	@Column(length = 45)
	@JsonProperty("concepto_recibo")
	private String concepto_recibo;
	@JsonProperty("fecha_recibo")
	private Date fecha_recibo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_inquilino", referencedColumnName="id")
	private Inquilinos inquilino;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name="id_inmueble", referencedColumnName="id")
	private Inmuebles inmueble;
	/**
	 * 
	 */
	public Recibos() {
		super();
	}
	/**
	 * @param importe_recibo
	 * @param concepto_recibo
	 * @param fecha_recibo
	 * @param inquilino
	 * @param inmueble
	 */
	public Recibos(Double importe_recibo, String concepto_recibo, Date fecha_recibo, Inquilinos inquilino,
			Inmuebles inmueble) {
		super();
		this.importe_recibo = importe_recibo;
		this.concepto_recibo = concepto_recibo;
		this.fecha_recibo = fecha_recibo;
		this.inquilino = inquilino;
		this.inmueble = inmueble;
	}
	/**
	 * @param id
	 * @param importe_recibo
	 * @param concepto_recibo
	 * @param fecha_recibo
	 * @param inquilino
	 * @param inmueble
	 */
	public Recibos(Long id, Double importe_recibo, String concepto_recibo, Date fecha_recibo, Inquilinos inquilino,
			Inmuebles inmueble) {
		super();
		this.id = id;
		this.importe_recibo = importe_recibo;
		this.concepto_recibo = concepto_recibo;
		this.fecha_recibo = fecha_recibo;
		this.inquilino = inquilino;
		this.inmueble = inmueble;
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
	 * @return the importe_recibo
	 */
	public Double getImporte_recibo() {
		return importe_recibo;
	}
	/**
	 * @param importe_recibo the importe_recibo to set
	 */
	public void setImporte_recibo(Double importe_recibo) {
		this.importe_recibo = importe_recibo;
	}
	/**
	 * @return the concepto_recibo
	 */
	public String getConcepto_recibo() {
		return concepto_recibo;
	}
	/**
	 * @param concepto_recibo the concepto_recibo to set
	 */
	public void setConcepto_recibo(String concepto_recibo) {
		this.concepto_recibo = concepto_recibo;
	}
	/**
	 * @return the fecha_recibo
	 */
	public Date getFecha_recibo() {
		return fecha_recibo;
	}
	/**
	 * @param fecha_recibo the fecha_recibo to set
	 */
	public void setFecha_recibo(Date fecha_recibo) {
		this.fecha_recibo = fecha_recibo;
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
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
