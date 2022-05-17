/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.service;

import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.recibos.model.Recibos;
import es.deepcode.gestionalquileres.recibos.response.ReciboResponseRest;

/**
 * @author aocarballo
 *
 */
public interface IReciboService {
	public ResponseEntity<ReciboResponseRest> buscar();
	public ResponseEntity<ReciboResponseRest> buscarID(Long id);
	public ResponseEntity<ReciboResponseRest> crear(Recibos recibo);
	public ResponseEntity<ReciboResponseRest> actualizar(Recibos recibo, Long id);
	public ResponseEntity<ReciboResponseRest> eliminar(Long id);
}
