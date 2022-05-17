/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.response;

import es.deepcode.gestionalquileres.response.ResponseRest;

/**
 * @author aocarballo
 *
 */
public class InquilinoResponseRest extends ResponseRest{
	private InquilinoResponse inquilinoResponse = new InquilinoResponse();

	/**
	 * @return the inquilinoResponse
	 */
	public InquilinoResponse getInquilinoResponse() {
		return inquilinoResponse;
	}

	/**
	 * @param inquilinoResponse the inquilinoResponse to set
	 */
	public void setInquilinoResponse(InquilinoResponse inquilinoResponse) {
		this.inquilinoResponse = inquilinoResponse;
	}

}
