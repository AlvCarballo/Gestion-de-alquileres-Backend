/**
 * 
 */
package es.deepcode.gestionalquileres.usuarios.service;


import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.usuarios.response.UsuarioResponseRest;

/**
 * @author aocarballo
 *
 */
public interface IUsuarioService {
	public ResponseEntity<UsuarioResponseRest> buscarUsuarios();
}
