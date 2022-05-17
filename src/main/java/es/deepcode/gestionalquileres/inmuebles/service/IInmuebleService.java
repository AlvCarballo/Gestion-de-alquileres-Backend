/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.service;

import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;
import es.deepcode.gestionalquileres.inmuebles.response.InmuebleResponseRest;

/**
 * @author aocarballo
 *
 */
public interface IInmuebleService {
	
	public ResponseEntity<InmuebleResponseRest> buscar();
	public ResponseEntity<InmuebleResponseRest> buscarID(Long id);
	public ResponseEntity<InmuebleResponseRest> crear(Inmuebles inmueble);
	public ResponseEntity<InmuebleResponseRest> actualizar(Inmuebles inmueble, Long id);
	public ResponseEntity<InmuebleResponseRest> eliminar(Long id);
}
