/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.deepcode.gestionalquileres.fincas.dao.IFincaDao;
import es.deepcode.gestionalquileres.fincas.model.Fincas;


/**
 * @author aocarballo
 *
 */
@Service
public class FincaServiceImpl implements IFincaService{
	private static final Logger log = LoggerFactory.getLogger(FincaServiceImpl.class);
	@Autowired
	private IFincaDao fincaDao;
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public List<Fincas> findAll() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscar()");
		return (List<Fincas>) fincaDao.findAll();
	}
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public Page<Fincas> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return fincaDao.findAll(pageable);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional(readOnly = true)
	public Fincas findById(Long id) {
		log.info("Inicio del metodo buscarID(id)");
		return fincaDao.findById(id).orElse(null);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Fincas save(Fincas finca) {
		log.info("Inicio del metodo crear()");
		return fincaDao.save(finca);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Fincas update(Fincas finca, Long id) {
		log.info("Inicio del metodo actualizar()");
		return fincaDao.save(finca);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public void delete(Long id) {
		log.info("Inicio del metodo eliminar()");
		fincaDao.deleteById(id);
	}
	
	
}
