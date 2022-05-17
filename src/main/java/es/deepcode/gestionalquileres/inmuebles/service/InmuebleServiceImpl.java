/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.service;


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

import es.deepcode.gestionalquileres.inmuebles.dao.IInmuebleDao;
import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;
import es.deepcode.gestionalquileres.inmuebles.response.InmuebleResponseRest;

/**
 * @author aocarballo
 *
 */
@Service
public class InmuebleServiceImpl implements IInmuebleService{
	private static final Logger log = LoggerFactory.getLogger(InmuebleServiceImpl.class);
	@Autowired
	private IInmuebleDao inmuebleDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<InmuebleResponseRest> buscar() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarInmuebles()");
		InmuebleResponseRest response = new InmuebleResponseRest();
		try {
			List<Inmuebles> listInmuebles = (List<Inmuebles>) inmuebleDao.findAll();
			response.getInmuebleResponse().setInmueble(listInmuebles);
			response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar inmuebles: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<InmuebleResponseRest> buscarID(Long id) {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarInmueblesID()");
		InmuebleResponseRest response = new InmuebleResponseRest();
		List<Inmuebles> listInmuebles = new ArrayList<Inmuebles>();
		try {
			Optional<Inmuebles> inmueble = inmuebleDao.findById(id);
			if(inmueble.isPresent()) {
				listInmuebles.add(inmueble.get());
				response.getInmuebleResponse().setInmueble(listInmuebles);
				response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
			}else {
				log.error("Inmueble no emcontrada");
				response.setMetadata("Respuesta KO", "404", "Inmueble no encontrada");
				return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar inmuebles: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<InmuebleResponseRest> crear(Inmuebles inmueble) {
		log.info("Inicio del metodo crear()");
		InmuebleResponseRest response = new InmuebleResponseRest();
		List<Inmuebles> listInmuebles = new ArrayList<Inmuebles>();
		try {
			Inmuebles inmuebleGuardada = inmuebleDao.save(inmueble);
			if(inmuebleGuardada != null) {
				listInmuebles.add(inmueble);
				response.getInmuebleResponse().setInmueble(listInmuebles);
				response.setMetadata("Respuesta OK", "200", "Inmueble guardada");
			}else {
				log.error("Error al guardar la inmueble");
				response.setMetadata("Respuesta KO", "400", "Inmueble no guardada");
				return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400.
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al guardar");
			log.error("Error al crear inmuebles: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<InmuebleResponseRest> actualizar(Inmuebles inmueble, Long id) {
		log.info("Inicio del metodo actualizar()");
		InmuebleResponseRest response = new InmuebleResponseRest();
		List<Inmuebles> listInmuebles = new ArrayList<Inmuebles>();
		try {
			Optional<Inmuebles> inmuebleBuscada = inmuebleDao.findById(id);
			
			if(inmuebleBuscada.isPresent()) {
				inmuebleBuscada.get().setRefCatastralInmueble(inmueble.getRefCatastralInmueble());
				inmuebleBuscada.get().setPisoInmueble(inmueble.getPisoInmueble());
				inmuebleBuscada.get().setLetraInmueble(inmueble.getLetraInmueble());
				inmuebleBuscada.get().setPropietario(inmueble.getPropietario());
				inmuebleBuscada.get().setFinca(inmueble.getFinca());
				inmuebleBuscada.get().setInquilino(inmueble.getInquilino());
				
				Inmuebles inmuebleActualizar = inmuebleDao.save(inmuebleBuscada.get()); //actualizando
				if(inmuebleActualizar != null) {
					response.setMetadata("Respuesta OK", "200", "Inmueble actualizada");
					listInmuebles.add(inmuebleActualizar);
					response.getInmuebleResponse().setInmueble(listInmuebles);
				}else {
					log.error("Error al actualizar la inmueble");
					response.setMetadata("Respuesta KO", "400", "Inmueble no actualizada");
					return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400
				}
			}else {
				log.error("Error al actualizar la inmueble");
				response.setMetadata("Respuesta KO", "404", "Inmueble no actualizada");
				return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al actualizar");
			log.error("Error al crear inmuebles: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<InmuebleResponseRest> eliminar(Long id) {
		log.info("Inicio del metodo eliminar()");
		InmuebleResponseRest response = new InmuebleResponseRest();
		try {
			inmuebleDao.deleteById(id);
			response.setMetadata("Respuesta OK", "200", "Inmueble eliminada");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al eliminar");
			log.error("Error al eliminar inmuebles: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InmuebleResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}

}
