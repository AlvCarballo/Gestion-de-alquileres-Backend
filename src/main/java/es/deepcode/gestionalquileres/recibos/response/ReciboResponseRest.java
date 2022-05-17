/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.response;

import es.deepcode.gestionalquileres.response.ResponseRest;

/**
 * @author aocarballo
 *
 */
public class ReciboResponseRest extends ResponseRest{
	private ReciboResponse reciboResponse = new ReciboResponse();

	/**
	 * @return the reciboResponse
	 */
	public ReciboResponse getReciboResponse() {
		return reciboResponse;
	}

	/**
	 * @param reciboResponse the reciboResponse to set
	 */
	public void setReciboResponse(ReciboResponse reciboResponse) {
		this.reciboResponse = reciboResponse;
	}

}
