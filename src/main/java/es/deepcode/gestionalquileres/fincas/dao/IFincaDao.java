/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.dao;

import org.springframework.data.repository.CrudRepository;

import es.deepcode.gestionalquileres.fincas.model.Fincas;


/**
 * @author aocarballo
 *
 */
public interface IFincaDao extends CrudRepository<Fincas, Long>{

}
