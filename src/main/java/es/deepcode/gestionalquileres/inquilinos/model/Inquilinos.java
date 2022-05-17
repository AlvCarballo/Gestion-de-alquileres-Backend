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
	private Long id;
	@Column(length = 9)
	private String dniInquilino;
	@Column(length = 45)
	private String nombreInquilino;
	@Column(length = 90)
	private String apellidosInquilino;
	@Column(length = 45)
	private String tipoViaInquilino;
	@Column(length = 45)
	private String direccionInquilino;
	private int numeroInquilino;
	@Column(length = 45)
	private String pisoInquilino;
	@Column(length = 4)
	private String letraInquilino;
	@Column(length = 24)
	private String ccInquilino;
	@Column(length = 45)
	private String emailInquilino;
	private int movilInquilino;
	private int telefonoInquilino;
	/**
	 * 
	 */
	public Inquilinos() {
		super();
	}
	/**
	 * @param id
	 * @param dniInquilino
	 * @param nombreInquilino
	 * @param apellidosInquilino
	 * @param tipoViaInquilino
	 * @param direccionInquilino
	 * @param numeroInquilino
	 * @param pisoInquilino
	 * @param letraInquilino
	 * @param ccInquilino
	 * @param emailInquilino
	 * @param movilInquilino
	 * @param telefonoInquilino
	 */
	public Inquilinos(Long id, String dniInquilino, String nombreInquilino, String apellidosInquilino,
			String tipoViaInquilino, String direccionInquilino, int numeroInquilino, String pisoInquilino,
			String letraInquilino, String ccInquilino, String emailInquilino, int movilInquilino,
			int telefonoInquilino) {
		super();
		this.id = id;
		this.dniInquilino = dniInquilino;
		this.nombreInquilino = nombreInquilino;
		this.apellidosInquilino = apellidosInquilino;
		this.tipoViaInquilino = tipoViaInquilino;
		this.direccionInquilino = direccionInquilino;
		this.numeroInquilino = numeroInquilino;
		this.pisoInquilino = pisoInquilino;
		this.letraInquilino = letraInquilino;
		this.ccInquilino = ccInquilino;
		this.emailInquilino = emailInquilino;
		this.movilInquilino = movilInquilino;
		this.telefonoInquilino = telefonoInquilino;
	}
	/**
	 * @param dniInquilino
	 * @param nombreInquilino
	 * @param apellidosInquilino
	 * @param tipoViaInquilino
	 * @param direccionInquilino
	 * @param numeroInquilino
	 * @param pisoInquilino
	 * @param letraInquilino
	 * @param ccInquilino
	 * @param emailInquilino
	 * @param movilInquilino
	 * @param telefonoInquilino
	 */
	public Inquilinos(String dniInquilino, String nombreInquilino, String apellidosInquilino, String tipoViaInquilino,
			String direccionInquilino, int numeroInquilino, String pisoInquilino, String letraInquilino,
			String ccInquilino, String emailInquilino, int movilInquilino, int telefonoInquilino) {
		super();
		this.dniInquilino = dniInquilino;
		this.nombreInquilino = nombreInquilino;
		this.apellidosInquilino = apellidosInquilino;
		this.tipoViaInquilino = tipoViaInquilino;
		this.direccionInquilino = direccionInquilino;
		this.numeroInquilino = numeroInquilino;
		this.pisoInquilino = pisoInquilino;
		this.letraInquilino = letraInquilino;
		this.ccInquilino = ccInquilino;
		this.emailInquilino = emailInquilino;
		this.movilInquilino = movilInquilino;
		this.telefonoInquilino = telefonoInquilino;
	}
	@Override
	public String toString() {
		return "Inquilinos [id=" + id + ", dniInquilino=" + dniInquilino + ", nombreInquilino="
				+ nombreInquilino + ", apellidosInquilino=" + apellidosInquilino + ", tipoViaInquilino="
				+ tipoViaInquilino + ", direccionInquilino=" + direccionInquilino + ", numeroInquilino="
				+ numeroInquilino + ", pisoInquilino=" + pisoInquilino + ", letraInquilino=" + letraInquilino
				+ ", ccInquilino=" + ccInquilino + ", emailInquilino=" + emailInquilino + ", movilInquilino="
				+ movilInquilino + ", telefonoInquilino=" + telefonoInquilino + "]";
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
	 * @return the dniInquilino
	 */
	public String getDniInquilino() {
		return dniInquilino;
	}
	/**
	 * @param dniInquilino the dniInquilino to set
	 */
	public void setDniInquilino(String dniInquilino) {
		this.dniInquilino = dniInquilino;
	}
	/**
	 * @return the nombreInquilino
	 */
	public String getNombreInquilino() {
		return nombreInquilino;
	}
	/**
	 * @param nombreInquilino the nombreInquilino to set
	 */
	public void setNombreInquilino(String nombreInquilino) {
		this.nombreInquilino = nombreInquilino;
	}
	/**
	 * @return the apellidosInquilino
	 */
	public String getApellidosInquilino() {
		return apellidosInquilino;
	}
	/**
	 * @param apellidosInquilino the apellidosInquilino to set
	 */
	public void setApellidosInquilino(String apellidosInquilino) {
		this.apellidosInquilino = apellidosInquilino;
	}
	/**
	 * @return the tipoViaInquilino
	 */
	public String getTipoViaInquilino() {
		return tipoViaInquilino;
	}
	/**
	 * @param tipoViaInquilino the tipoViaInquilino to set
	 */
	public void setTipoViaInquilino(String tipoViaInquilino) {
		this.tipoViaInquilino = tipoViaInquilino;
	}
	/**
	 * @return the direccionInquilino
	 */
	public String getDireccionInquilino() {
		return direccionInquilino;
	}
	/**
	 * @param direccionInquilino the direccionInquilino to set
	 */
	public void setDireccionInquilino(String direccionInquilino) {
		this.direccionInquilino = direccionInquilino;
	}
	/**
	 * @return the numeroInquilino
	 */
	public int getNumeroInquilino() {
		return numeroInquilino;
	}
	/**
	 * @param numeroInquilino the numeroInquilino to set
	 */
	public void setNumeroInquilino(int numeroInquilino) {
		this.numeroInquilino = numeroInquilino;
	}
	/**
	 * @return the pisoInquilino
	 */
	public String getPisoInquilino() {
		return pisoInquilino;
	}
	/**
	 * @param pisoInquilino the pisoInquilino to set
	 */
	public void setPisoInquilino(String pisoInquilino) {
		this.pisoInquilino = pisoInquilino;
	}
	/**
	 * @return the letraInquilino
	 */
	public String getLetraInquilino() {
		return letraInquilino;
	}
	/**
	 * @param letraInquilino the letraInquilino to set
	 */
	public void setLetraInquilino(String letraInquilino) {
		this.letraInquilino = letraInquilino;
	}
	/**
	 * @return the ccInquilino
	 */
	public String getCcInquilino() {
		return ccInquilino;
	}
	/**
	 * @param ccInquilino the ccInquilino to set
	 */
	public void setCcInquilino(String ccInquilino) {
		this.ccInquilino = ccInquilino;
	}
	/**
	 * @return the emailInquilino
	 */
	public String getEmailInquilino() {
		return emailInquilino;
	}
	/**
	 * @param emailInquilino the emailInquilino to set
	 */
	public void setEmailInquilino(String emailInquilino) {
		this.emailInquilino = emailInquilino;
	}
	/**
	 * @return the movilInquilino
	 */
	public int getMovilInquilino() {
		return movilInquilino;
	}
	/**
	 * @param movilInquilino the movilInquilino to set
	 */
	public void setMovilInquilino(int movilInquilino) {
		this.movilInquilino = movilInquilino;
	}
	/**
	 * @return the telefonoInquilino
	 */
	public int getTelefonoInquilino() {
		return telefonoInquilino;
	}
	/**
	 * @param telefonoInquilino the telefonoInquilino to set
	 */
	public void setTelefonoInquilino(int telefonoInquilino) {
		this.telefonoInquilino = telefonoInquilino;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
