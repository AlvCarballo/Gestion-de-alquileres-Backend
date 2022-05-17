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
	private Long id;
	private Boolean tipoPersonaPropietario;
	@Column(length = 9)
	private String dniPropietario;
	@Column(length = 45)
	private String nombrePropietario;
	@Column(length = 90)
	private String apellidosPropietario;
	@Column(length = 45)
	private String tipoViaPropietario;
	@Column(length = 45)
	private String direccionPropietario;
	private int numeroPropietario;
	@Column(length = 45)
	private String pisoPropietario;
	@Column(length = 4)
	private String letraPropietario;
	@Column(length = 24)
	private String ccPropietario;
	@Column(length = 45)
	private String emailPropietario;
	private int movilPropietario;
	private int telefonoPropietario;
	/**
	 * 
	 */
	public Propietarios() {
		super();
	}
	/**
	 * @param id
	 * @param tipoPersonaPropietario
	 * @param dniPropietario
	 * @param nombrePropietario
	 * @param apellidosPropietario
	 * @param tipoViaPropietario
	 * @param direccionPropietario
	 * @param numeroPropietario
	 * @param pisoPropietario
	 * @param letraPropietario
	 * @param ccPropietario
	 * @param emailPropietario
	 * @param movilPropietario
	 * @param telefonoPropietario
	 */
	public Propietarios(Long id, Boolean tipoPersonaPropietario, String dniPropietario,
			String nombrePropietario, String apellidosPropietario, String tipoViaPropietario,
			String direccionPropietario, int numeroPropietario, String pisoPropietario, String letraPropietario,
			String ccPropietario, String emailPropietario, int movilPropietario, int telefonoPropietario) {
		super();
		this.id = id;
		this.tipoPersonaPropietario = tipoPersonaPropietario;
		this.dniPropietario = dniPropietario;
		this.nombrePropietario = nombrePropietario;
		this.apellidosPropietario = apellidosPropietario;
		this.tipoViaPropietario = tipoViaPropietario;
		this.direccionPropietario = direccionPropietario;
		this.numeroPropietario = numeroPropietario;
		this.pisoPropietario = pisoPropietario;
		this.letraPropietario = letraPropietario;
		this.ccPropietario = ccPropietario;
		this.emailPropietario = emailPropietario;
		this.movilPropietario = movilPropietario;
		this.telefonoPropietario = telefonoPropietario;
	}
	/**
	 * @param tipoPersonaPropietario
	 * @param dniPropietario
	 * @param nombrePropietario
	 * @param apellidosPropietario
	 * @param tipoViaPropietario
	 * @param direccionPropietario
	 * @param numeroPropietario
	 * @param pisoPropietario
	 * @param letraPropietario
	 * @param ccPropietario
	 * @param emailPropietario
	 * @param movilPropietario
	 * @param telefonoPropietario
	 */
	public Propietarios(Boolean tipoPersonaPropietario, String dniPropietario, String nombrePropietario,
			String apellidosPropietario, String tipoViaPropietario, String direccionPropietario, int numeroPropietario,
			String pisoPropietario, String letraPropietario, String ccPropietario, String emailPropietario,
			int movilPropietario, int telefonoPropietario) {
		super();
		this.tipoPersonaPropietario = tipoPersonaPropietario;
		this.dniPropietario = dniPropietario;
		this.nombrePropietario = nombrePropietario;
		this.apellidosPropietario = apellidosPropietario;
		this.tipoViaPropietario = tipoViaPropietario;
		this.direccionPropietario = direccionPropietario;
		this.numeroPropietario = numeroPropietario;
		this.pisoPropietario = pisoPropietario;
		this.letraPropietario = letraPropietario;
		this.ccPropietario = ccPropietario;
		this.emailPropietario = emailPropietario;
		this.movilPropietario = movilPropietario;
		this.telefonoPropietario = telefonoPropietario;
	}
	@Override
	public String toString() {
		return "Propietarios [id=" + id + ", tipoPersonaPropietario=" + tipoPersonaPropietario
				+ ", dniPropietario=" + dniPropietario + ", nombrePropietario=" + nombrePropietario
				+ ", apellidosPropietario=" + apellidosPropietario + ", tipoViaPropietario=" + tipoViaPropietario
				+ ", direccionPropietario=" + direccionPropietario + ", numeroPropietario=" + numeroPropietario
				+ ", pisoPropietario=" + pisoPropietario + ", letraPropietario=" + letraPropietario + ", ccPropietario="
				+ ccPropietario + ", emailPropietario=" + emailPropietario + ", movilPropietario=" + movilPropietario
				+ ", telefonoPropietario=" + telefonoPropietario + "]";
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
	 * @return the tipoPersonaPropietario
	 */
	public Boolean getTipoPersonaPropietario() {
		return tipoPersonaPropietario;
	}
	/**
	 * @param tipoPersonaPropietario the tipoPersonaPropietario to set
	 */
	public void setTipoPersonaPropietario(Boolean tipoPersonaPropietario) {
		this.tipoPersonaPropietario = tipoPersonaPropietario;
	}
	/**
	 * @return the dniPropietario
	 */
	public String getDniPropietario() {
		return dniPropietario;
	}
	/**
	 * @param dniPropietario the dniPropietario to set
	 */
	public void setDniPropietario(String dniPropietario) {
		this.dniPropietario = dniPropietario;
	}
	/**
	 * @return the nombrePropietario
	 */
	public String getNombrePropietario() {
		return nombrePropietario;
	}
	/**
	 * @param nombrePropietario the nombrePropietario to set
	 */
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}
	/**
	 * @return the apellidosPropietario
	 */
	public String getApellidosPropietario() {
		return apellidosPropietario;
	}
	/**
	 * @param apellidosPropietario the apellidosPropietario to set
	 */
	public void setApellidosPropietario(String apellidosPropietario) {
		this.apellidosPropietario = apellidosPropietario;
	}
	/**
	 * @return the tipoViaPropietario
	 */
	public String getTipoViaPropietario() {
		return tipoViaPropietario;
	}
	/**
	 * @param tipoViaPropietario the tipoViaPropietario to set
	 */
	public void setTipoViaPropietario(String tipoViaPropietario) {
		this.tipoViaPropietario = tipoViaPropietario;
	}
	/**
	 * @return the direccionPropietario
	 */
	public String getDireccionPropietario() {
		return direccionPropietario;
	}
	/**
	 * @param direccionPropietario the direccionPropietario to set
	 */
	public void setDireccionPropietario(String direccionPropietario) {
		this.direccionPropietario = direccionPropietario;
	}
	/**
	 * @return the numeroPropietario
	 */
	public int getNumeroPropietario() {
		return numeroPropietario;
	}
	/**
	 * @param numeroPropietario the numeroPropietario to set
	 */
	public void setNumeroPropietario(int numeroPropietario) {
		this.numeroPropietario = numeroPropietario;
	}
	/**
	 * @return the pisoPropietario
	 */
	public String getPisoPropietario() {
		return pisoPropietario;
	}
	/**
	 * @param pisoPropietario the pisoPropietario to set
	 */
	public void setPisoPropietario(String pisoPropietario) {
		this.pisoPropietario = pisoPropietario;
	}
	/**
	 * @return the letraPropietario
	 */
	public String getLetraPropietario() {
		return letraPropietario;
	}
	/**
	 * @param letraPropietario the letraPropietario to set
	 */
	public void setLetraPropietario(String letraPropietario) {
		this.letraPropietario = letraPropietario;
	}
	/**
	 * @return the ccPropietario
	 */
	public String getCcPropietario() {
		return ccPropietario;
	}
	/**
	 * @param ccPropietario the ccPropietario to set
	 */
	public void setCcPropietario(String ccPropietario) {
		this.ccPropietario = ccPropietario;
	}
	/**
	 * @return the emailPropietario
	 */
	public String getEmailPropietario() {
		return emailPropietario;
	}
	/**
	 * @param emailPropietario the emailPropietario to set
	 */
	public void setEmailPropietario(String emailPropietario) {
		this.emailPropietario = emailPropietario;
	}
	/**
	 * @return the movilPropietario
	 */
	public int getMovilPropietario() {
		return movilPropietario;
	}
	/**
	 * @param movilPropietario the movilPropietario to set
	 */
	public void setMovilPropietario(int movilPropietario) {
		this.movilPropietario = movilPropietario;
	}
	/**
	 * @return the telefonoPropietario
	 */
	public int getTelefonoPropietario() {
		return telefonoPropietario;
	}
	/**
	 * @param telefonoPropietario the telefonoPropietario to set
	 */
	public void setTelefonoPropietario(int telefonoPropietario) {
		this.telefonoPropietario = telefonoPropietario;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
