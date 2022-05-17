/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.dao;

import org.springframework.data.repository.CrudRepository;

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;
import es.deepcode.gestionalquileres.recibos.model.Recibos;

/**
 * @author aocarballo
 *
 */
public interface IReciboDao  extends CrudRepository<Recibos, Long>{

}
