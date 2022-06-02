/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;

/**
 * @author aocarballo
 *
 */
public interface IInmuebleDao extends JpaRepository<Inmuebles, Long>{

}
