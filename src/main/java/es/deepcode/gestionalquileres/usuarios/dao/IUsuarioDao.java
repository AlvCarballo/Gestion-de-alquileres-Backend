/**
 * 
 */
package es.deepcode.gestionalquileres.usuarios.dao;

import org.springframework.data.repository.CrudRepository;

import es.deepcode.gestionalquileres.usuarios.model.Usuarios;

/**
 * @author aocarballo
 *
 */
public interface IUsuarioDao extends CrudRepository<Usuarios, Long>{
	public Usuarios findByNombreUsuario(String nombreUsuario);
/*
	@Query("SELECT u from Usuarios where u.nombreUsuario=?1")
	public Usuarios findByNombreUsuarioV2(String nombreUsuario);
	*/
}
