/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.deepcode.gestionalquileres.recibos.dao.IReciboDao;
import es.deepcode.gestionalquileres.recibos.model.Recibos;

/**
 * @author aocarballo
 *
 */
@Service
public class ReciboServiceImpl implements IReciboService{
	private static final Logger log = LoggerFactory.getLogger(ReciboServiceImpl.class);
	@Autowired
	private IReciboDao reciboDao;
	
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public List<Recibos> findAll() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscar()");
		return (List<Recibos>) reciboDao.findAll();
	}

	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public Page<Recibos> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return reciboDao.findAll(pageable);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional(readOnly = true)
	public Recibos findById(Long id) {
		log.info("Inicio del metodo buscarID(id)");
		return reciboDao.findById(id).orElse(null);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Recibos save(Recibos recibo) {
		log.info("Inicio del metodo crear()");
		return reciboDao.save(recibo);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Recibos update(Recibos recibo, Long id) {
		log.info("Inicio del metodo actualizar()");
		return reciboDao.save(recibo);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public void delete(Long id) {
		log.info("Inicio del metodo eliminar()");
		reciboDao.deleteById(id);
	}
}
