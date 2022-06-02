/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.deepcode.gestionalquileres.inquilinos.dao.IInquilinoDao;
import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;

/**
 * @author aocarballo
 *
 */
@Service
public class InquilinoServiceImpl implements IInquilinoService{
	private static final Logger log = LoggerFactory.getLogger(InquilinoServiceImpl.class);
	@Autowired
	private IInquilinoDao inquilinoDao;

	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public List<Inquilinos> findAll() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscar()");
		return (List<Inquilinos>) inquilinoDao.findAll();
	}

	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public Page<Inquilinos> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return inquilinoDao.findAll(pageable);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional(readOnly = true)
	public Inquilinos findById(Long id) {
		log.info("Inicio del metodo buscarID(id)");
		return inquilinoDao.findById(id).orElse(null);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Inquilinos save(Inquilinos inquilino) {
		log.info("Inicio del metodo crear()");
		return inquilinoDao.save(inquilino);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Inquilinos update(Inquilinos inquilino, Long id) {
		log.info("Inicio del metodo actualizar()");
		return inquilinoDao.save(inquilino);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public void delete(Long id) {
		log.info("Inicio del metodo eliminar()");
		inquilinoDao.deleteById(id);
	}

}
