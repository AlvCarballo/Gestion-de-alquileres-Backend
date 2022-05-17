/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.dao;

import org.springframework.data.repository.CrudRepository;

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;

/**
 * @author aocarballo
 *
 */
public interface IInmuebleDao extends CrudRepository<Inmuebles, Long>{

}
