/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.deepcode.gestionalquileres.inmuebles.dao.IInmuebleDao;
import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;

/**
 * @author aocarballo
 *
 */
@Service
public class InmuebleServiceImpl implements IInmuebleService{
	private static final Logger log = LoggerFactory.getLogger(InmuebleServiceImpl.class);
	@Autowired
	private IInmuebleDao inmuebleDao;
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public List<Inmuebles> findAll() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscar()");
		return (List<Inmuebles>) inmuebleDao.findAll();
	}
	@Override
	@Transactional(readOnly = true)
	@CrossOrigin(origins = {"http://localhost:4200"})
	public Page<Inmuebles> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return inmuebleDao.findAll(pageable);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional(readOnly = true)
	public Inmuebles findById(Long id) {
		log.info("Inicio del metodo buscarID(id)");
		return inmuebleDao.findById(id).orElse(null);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Inmuebles save(Inmuebles inmueble) {
		log.info("Inicio del metodo crear()");
		return inmuebleDao.save(inmueble);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Inmuebles update(Inmuebles inmueble, Long id) {
		log.info("Inicio del metodo actualizar()");
		return inmuebleDao.save(inmueble);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public void delete(Long id) {
		log.info("Inicio del metodo eliminar()");
		inmuebleDao.deleteById(id);
	}
	

}
