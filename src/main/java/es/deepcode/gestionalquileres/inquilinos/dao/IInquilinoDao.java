/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;

/**
 * @author aocarballo
 *
 */
public interface IInquilinoDao extends JpaRepository<Inquilinos, Long>{

}
