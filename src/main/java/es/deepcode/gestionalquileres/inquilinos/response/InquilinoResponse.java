/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.response;

import java.util.List;

import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;

/**
 * @author aocarballo
 *
 */
public class InquilinoResponse {
	private List<Inquilinos> inquilino;
	

	/**
	 * @return the inquilino
	 */
	public List<Inquilinos> getInquilino() {
		return inquilino;
	}

	/**
	 * @param inquilino the inquilino to set
	 */
	public void setInquilino(List<Inquilinos> inquilino) {
		this.inquilino = inquilino;
	}
	
}
