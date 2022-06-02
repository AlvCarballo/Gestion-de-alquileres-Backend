/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.deepcode.gestionalquileres.fincas.model.Fincas;


/**
 * @author aocarballo
 *
 */
public interface IFincaDao extends JpaRepository<Fincas, Long>{

}
