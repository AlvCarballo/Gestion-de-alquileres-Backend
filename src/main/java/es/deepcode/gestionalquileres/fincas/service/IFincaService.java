/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.service;

import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.fincas.model.Fincas;
import es.deepcode.gestionalquileres.fincas.response.FincaResponseRest;

/**
 * @author aocarballo
 *
 */
public interface IFincaService {
	public ResponseEntity<FincaResponseRest> buscar();
	public ResponseEntity<FincaResponseRest> buscarID(Long id);
	public ResponseEntity<FincaResponseRest> crear(Fincas finca);
	public ResponseEntity<FincaResponseRest> actualizar(Fincas finca, Long id);
	public ResponseEntity<FincaResponseRest> eliminar(Long id);
}
