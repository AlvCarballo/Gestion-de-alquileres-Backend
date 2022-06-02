/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;

/**
 * @author aocarballo
 *
 */
public interface IPropietarioDao extends JpaRepository<Propietarios, Long>{

}
