/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.deepcode.gestionalquileres.propietarios.dao.IPropietarioDao;
import es.deepcode.gestionalquileres.propietarios.model.Propietarios;

/**
 * @author aocarballo
 *
 */
@Service
public class PropietarioServiceImpl implements IPropietarioService{
	private static final Logger log = LoggerFactory.getLogger(PropietarioServiceImpl.class);
	@Autowired
	private IPropietarioDao propietarioDao;
	

	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public List<Propietarios> findAll() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscar()");
		return (List<Propietarios>) propietarioDao.findAll();
	}

	@CrossOrigin(origins = {"http://localhost:4200"})
	@Override
	@Transactional(readOnly = true)
	public Page<Propietarios> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return propietarioDao.findAll(pageable);
	}
	
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional(readOnly = true)
	public Propietarios findById(Long id) {
		log.info("Inicio del metodo buscarID(id)");
		return propietarioDao.findById(id).orElse(null);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Propietarios save(Propietarios propietario) {
		log.info("Inicio del metodo crear()");
		return propietarioDao.save(propietario);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public Propietarios update(Propietarios propietario, Long id) {
		log.info("Inicio del metodo actualizar()");
		return propietarioDao.save(propietario);
	}
	@Override
	@CrossOrigin(origins = {"http://localhost:4200"})
	@Transactional
	public void delete(Long id) {
		log.info("Inicio del metodo eliminar()");
		propietarioDao.deleteById(id);
	}
				
		

}
