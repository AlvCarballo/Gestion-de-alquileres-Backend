/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.deepcode.gestionalquileres.recibos.model.Recibos;

/**
 * @author aocarballo
 *
 */
public interface IReciboService {
	public List<Recibos> findAll();
	public Page<Recibos> findAll(Pageable pageable);
	public Recibos findById(Long id);
	public  Recibos save(Recibos recibo);
	public Recibos update(Recibos recibo, Long id);
	public void delete(Long id);
}
