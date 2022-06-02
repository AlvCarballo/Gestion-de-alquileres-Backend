/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;

/**
 * @author aocarballo
 *
 */
public interface IInmuebleService {
	
	public List<Inmuebles> findAll();
	public Page<Inmuebles> findAll(Pageable pageable);
	public Inmuebles findById(Long id);
	public  Inmuebles save(Inmuebles inmueble);
	public Inmuebles update(Inmuebles inmueble, Long id);
	public void delete(Long id);
}
