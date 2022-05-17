/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.service;

import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;
import es.deepcode.gestionalquileres.inquilinos.response.InquilinoResponseRest;

/**
 * @author aocarballo
 *
 */
public interface IInquilinoService {
	public ResponseEntity<InquilinoResponseRest> buscar();
	public ResponseEntity<InquilinoResponseRest> buscarID(Long id);
	public ResponseEntity<InquilinoResponseRest> crear(Inquilinos inquilino);
	public ResponseEntity<InquilinoResponseRest> actualizar(Inquilinos inquilino, Long id);
	public ResponseEntity<InquilinoResponseRest> eliminar(Long id);
}
