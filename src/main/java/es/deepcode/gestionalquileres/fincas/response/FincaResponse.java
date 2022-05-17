/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.response;

import java.util.List;

import es.deepcode.gestionalquileres.fincas.model.Fincas;

/**
 * @author aocarballo
 *
 */
public class FincaResponse {
	private List<Fincas> finca;

	/**
	 * @return the finca
	 */
	public List<Fincas> getFinca() {
		return finca;
	}

	/**
	 * @param finca the finca to set
	 */
	public void setFinca(List<Fincas> finca) {
		this.finca = finca;
	}
	

}
