/**
 * 
 */
package es.deepcode.gestionalquileres.usuarios.response;

import es.deepcode.gestionalquileres.response.ResponseRest;

/**
 * @author aocarballo
 *
 */
public class UsuarioResponseRest extends ResponseRest{
	private UsuarioResponse usuarioResponse = new UsuarioResponse();

	/**
	 * @return the usuarioResponse
	 */
	public UsuarioResponse getUsuarioResponse() {
		return usuarioResponse;
	}

	/**
	 * @param usuarioResponse the usuarioResponse to set
	 */
	public void setUsuarioResponse(UsuarioResponse usuarioResponse) {
		this.usuarioResponse = usuarioResponse;
	}

}
