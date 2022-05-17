/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.dao;

import org.springframework.data.repository.CrudRepository;

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;

/**
 * @author aocarballo
 *
 */
public interface IPropietarioDao extends CrudRepository<Propietarios, Long>{

}
