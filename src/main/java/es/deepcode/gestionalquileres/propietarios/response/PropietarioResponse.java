/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.response;

import java.util.List;

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;

/**
 * @author aocarballo
 *
 */
public class PropietarioResponse {
	private List<Propietarios> propietario;

	/**
	 * @return the propietario
	 */
	public List<Propietarios> getPropietario() {
		return propietario;
	}

	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(List<Propietarios> propietario) {
		this.propietario = propietario;
	}
	
}
