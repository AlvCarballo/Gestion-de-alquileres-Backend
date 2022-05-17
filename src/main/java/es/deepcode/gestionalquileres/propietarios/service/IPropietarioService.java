/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.service;

import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;
import es.deepcode.gestionalquileres.propietarios.response.PropietarioResponseRest;

/**
 * @author aocarballo
 *
 */
public interface IPropietarioService {
	public ResponseEntity<PropietarioResponseRest> buscar();
	public ResponseEntity<PropietarioResponseRest> buscarID(Long id);
	public ResponseEntity<PropietarioResponseRest> crear(Propietarios propietario);
	public ResponseEntity<PropietarioResponseRest> actualizar(Propietarios propietario, Long id);
	public ResponseEntity<PropietarioResponseRest> eliminar(Long id);
}
