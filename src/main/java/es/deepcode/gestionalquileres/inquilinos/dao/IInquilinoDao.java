/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.dao;

import org.springframework.data.repository.CrudRepository;

import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;

/**
 * @author aocarballo
 *
 */
public interface IInquilinoDao extends CrudRepository<Inquilinos, Long>{

}
