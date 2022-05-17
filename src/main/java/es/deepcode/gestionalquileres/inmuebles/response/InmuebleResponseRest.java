/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.response;

import es.deepcode.gestionalquileres.response.ResponseRest;

/**
 * @author aocarballo
 *
 */
public class InmuebleResponseRest extends ResponseRest{
	private InmuebleResponse inmuebleResponse = new InmuebleResponse();

	/**
	 * @return the inmuebleResponse
	 */
	public InmuebleResponse getInmuebleResponse() {
		return inmuebleResponse;
	}

	/**
	 * @param inmuebleResponse the inmuebleResponse to set
	 */
	public void setInmuebleResponse(InmuebleResponse inmuebleResponse) {
		this.inmuebleResponse = inmuebleResponse;
	}
	
}
