/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.deepcode.gestionalquileres.fincas.dao.IFincaDao;
import es.deepcode.gestionalquileres.fincas.model.Fincas;
import es.deepcode.gestionalquileres.fincas.response.FincaResponseRest;


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
	public ResponseEntity<FincaResponseRest> buscar() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarFincas()");
		FincaResponseRest response = new FincaResponseRest();
		try {
			List<Fincas> listFincas = (List<Fincas>) fincaDao.findAll();
			response.getFincaResponse().setFinca(listFincas);
			response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar fincas: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<FincaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<FincaResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<FincaResponseRest> buscarID(Long id) {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarFincasID()");
		FincaResponseRest response = new FincaResponseRest();
		List<Fincas> listFincas = new ArrayList<Fincas>();
		try {
			Optional<Fincas> finca = fincaDao.findById(id);
			if(finca.isPresent()) {
				listFincas.add(finca.get());
				response.getFincaResponse().setFinca(listFincas);
				response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
			}else {
				log.error("Finca no emcontrada");
				response.setMetadata("Respuesta KO", "404", "Finca no encontrada");
				return new ResponseEntity<FincaResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar fincas: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<FincaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<FincaResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<FincaResponseRest> crear(Fincas finca) {
		log.info("Inicio del metodo crear()");
		FincaResponseRest response = new FincaResponseRest();
		List<Fincas> listFincas = new ArrayList<Fincas>();
		try {
			Fincas fincaGuardada = fincaDao.save(finca);
			if(fincaGuardada != null) {
				listFincas.add(finca);
				response.getFincaResponse().setFinca(listFincas);
				response.setMetadata("Respuesta OK", "200", "Finca guardada");
			}else {
				log.error("Error al guardar la finca");
				response.setMetadata("Respuesta KO", "400", "Finca no guardada");
				return new ResponseEntity<FincaResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400.
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al guardar");
			log.error("Error al crear fincas: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<FincaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<FincaResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<FincaResponseRest> actualizar(Fincas finca, Long id) {
		log.info("Inicio del metodo actualizar()");
		FincaResponseRest response = new FincaResponseRest();
		List<Fincas> listFincas = new ArrayList<Fincas>();
		try {
			Optional<Fincas> fincaBuscada = fincaDao.findById(id);
			
			if(fincaBuscada.isPresent()) {
				fincaBuscada.get().setNombreFinca(finca.getNombreFinca());
				Fincas fincaActualizar = fincaDao.save(fincaBuscada.get()); //actualizando
				if(fincaActualizar != null) {
					response.setMetadata("Respuesta OK", "200", "Finca actualizada");
					listFincas.add(fincaActualizar);
					response.getFincaResponse().setFinca(listFincas);
				}else {
					log.error("Error al actualizar la finca");
					response.setMetadata("Respuesta KO", "400", "Finca no actualizada");
					return new ResponseEntity<FincaResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400
				}
			}else {
				log.error("Error al actualizar la finca");
				response.setMetadata("Respuesta KO", "404", "Finca no actualizada");
				return new ResponseEntity<FincaResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al actualizar");
			log.error("Error al crear fincas: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<FincaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<FincaResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<FincaResponseRest> eliminar(Long id) {
		log.info("Inicio del metodo eliminar()");
		FincaResponseRest response = new FincaResponseRest();
		try {
			fincaDao.deleteById(id);
			response.setMetadata("Respuesta OK", "200", "Finca eliminada");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al eliminar");
			log.error("Error al eliminar fincas: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<FincaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<FincaResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	
}
