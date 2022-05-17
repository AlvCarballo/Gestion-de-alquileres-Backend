/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.response;

import java.util.List;

import es.deepcode.gestionalquileres.recibos.model.Recibos;

/**
 * @author aocarballo
 *
 */
public class ReciboResponse {
	private List<Recibos> recibo;

	/**
	 * @return the recibo
	 */
	public List<Recibos> getRecibo() {
		return recibo;
	}

	/**
	 * @param recibos the recibo to set
	 */
	public void setRecibo(List<Recibos> recibos) {
		this.recibo = recibos;
	}
	
}
