/**
 * 
 */
package es.deepcode.gestionalquileres.usuarios.response;

import java.util.List;

import es.deepcode.gestionalquileres.usuarios.model.Usuarios;

/**
 * @author aocarballo
 *
 */
public class UsuarioResponse {
	private List<Usuarios> usuario;

	/**
	 * @return the usuario
	 */
	public List<Usuarios> getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(List<Usuarios> usuario) {
		this.usuario = usuario;
	}
	
}
