/**
 * 
 */
package es.deepcode.gestionalquileres.usuarios.service;


import es.deepcode.gestionalquileres.usuarios.model.Usuarios;

/**
 * @author aocarballo
 *
 */
public interface IUsuarioService {
	public Usuarios findByUsername(String username);
}
