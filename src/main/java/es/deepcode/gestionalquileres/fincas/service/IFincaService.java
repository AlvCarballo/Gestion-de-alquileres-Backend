/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.deepcode.gestionalquileres.fincas.model.Fincas;

/**
 * @author aocarballo
 *
 */
public interface IFincaService {
	
	public List<Fincas> findAll();
	public Page<Fincas> findAll(Pageable pageable);
	public Fincas findById(Long id);
	public  Fincas save(Fincas finca);
	public Fincas update(Fincas finca, Long id);
	public void delete(Long id);
}
