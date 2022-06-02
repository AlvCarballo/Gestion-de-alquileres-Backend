/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;

/**
 * @author aocarballo
 *
 */
public interface IInquilinoService {
	public List<Inquilinos> findAll();
	public Page<Inquilinos> findAll(Pageable pageable);
	public Inquilinos findById(Long id);
	public  Inquilinos save(Inquilinos inquilino);
	public Inquilinos update(Inquilinos inquilino, Long id);
	public void delete(Long id);
}
