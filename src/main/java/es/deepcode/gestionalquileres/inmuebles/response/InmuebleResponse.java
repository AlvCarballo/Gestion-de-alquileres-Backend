/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.response;

import java.util.List;

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;

/**
 * @author aocarballo
 *
 */
public class InmuebleResponse {
	private List<Inmuebles> inmueble;

	/**
	 * @return the inmueble
	 */
	public List<Inmuebles> getInmueble() {
		return inmueble;
	}

	/**
	 * @param inmueble the inmueble to set
	 */
	public void setInmueble(List<Inmuebles> inmueble) {
		this.inmueble = inmueble;
	}
	
	
}
