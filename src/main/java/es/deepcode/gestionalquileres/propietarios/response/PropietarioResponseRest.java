/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.response;

import es.deepcode.gestionalquileres.response.ResponseRest;

/**
 * @author aocarballo
 *
 */
public class PropietarioResponseRest extends ResponseRest{
	private PropietarioResponse propietarioResponse = new PropietarioResponse();

	/**
	 * @return the propietarioResponse
	 */
	public PropietarioResponse getPropietarioResponse() {
		return propietarioResponse;
	}

	/**
	 * @param propietarioResponse the propietarioResponse to set
	 */
	public void setPropietarioResponse(PropietarioResponse propietarioResponse) {
		this.propietarioResponse = propietarioResponse;
	}
	
}
