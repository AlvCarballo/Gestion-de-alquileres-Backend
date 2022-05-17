/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.response;

import es.deepcode.gestionalquileres.response.ResponseRest;

/**
 * @author aocarballo
 *
 */
public class FincaResponseRest extends ResponseRest{
	private FincaResponse fincaResponse = new FincaResponse();

	/**
	 * @return the fincaResponse
	 */
	public FincaResponse getFincaResponse() {
		return fincaResponse;
	}

	/**
	 * @param fincaResponse the fincaResponse to set
	 */
	public void setFincaResponse(FincaResponse fincaResponse) {
		this.fincaResponse = fincaResponse;
	}

}
