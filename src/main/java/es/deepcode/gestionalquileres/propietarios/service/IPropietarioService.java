/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;

/**
 * @author aocarballo
 *
 */
public interface IPropietarioService {
	public List<Propietarios> findAll();
	public Page<Propietarios> findAll(Pageable pageable);
	public Propietarios findById(Long id);
	public  Propietarios save(Propietarios propietario);
	public Propietarios update(Propietarios propietario, Long id);
	public void delete(Long id);
}
