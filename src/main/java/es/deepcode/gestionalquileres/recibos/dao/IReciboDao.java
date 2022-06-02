/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import es.deepcode.gestionalquileres.recibos.model.Recibos;

/**
 * @author aocarballo
 *
 */
public interface IReciboDao  extends JpaRepository<Recibos, Long>{

}
