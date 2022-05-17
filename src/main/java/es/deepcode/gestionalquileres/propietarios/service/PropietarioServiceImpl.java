/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.service;


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

import es.deepcode.gestionalquileres.propietarios.dao.IPropietarioDao;
import es.deepcode.gestionalquileres.propietarios.model.Propietarios;
import es.deepcode.gestionalquileres.propietarios.response.PropietarioResponseRest;

/**
 * @author aocarballo
 *
 */
@Service
public class PropietarioServiceImpl implements IPropietarioService{
	private static final Logger log = LoggerFactory.getLogger(PropietarioServiceImpl.class);
	@Autowired
	private IPropietarioDao propietarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<PropietarioResponseRest> buscar() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarPropietarios()");
		PropietarioResponseRest response = new PropietarioResponseRest();
		try {
			List<Propietarios> listPropietarios = (List<Propietarios>) propietarioDao.findAll();
			response.getPropietarioResponse().setPropietario(listPropietarios);
			response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar propietarios: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<PropietarioResponseRest> buscarID(Long id) {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarPropietariosID()");
		PropietarioResponseRest response = new PropietarioResponseRest();
		List<Propietarios> listPropietarios = new ArrayList<Propietarios>();
		try {
			Optional<Propietarios> propietario = propietarioDao.findById(id);
			if(propietario.isPresent()) {
				listPropietarios.add(propietario.get());
				response.getPropietarioResponse().setPropietario(listPropietarios);
				response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
			}else {
				log.error("Propietario no emcontrada");
				response.setMetadata("Respuesta KO", "404", "Propietario no encontrada");
				return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar propietarios: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<PropietarioResponseRest> crear(Propietarios propietario) {
		log.info("Inicio del metodo crear()");
		PropietarioResponseRest response = new PropietarioResponseRest();
		List<Propietarios> listPropietarios = new ArrayList<Propietarios>();
		try {
			Propietarios propietarioGuardada = propietarioDao.save(propietario);
			if(propietarioGuardada != null) {
				listPropietarios.add(propietario);
				response.getPropietarioResponse().setPropietario(listPropietarios);
				response.setMetadata("Respuesta OK", "200", "Propietario guardada");
			}else {
				log.error("Error al guardar la propietario");
				response.setMetadata("Respuesta KO", "400", "Propietario no guardada");
				return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400.
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al guardar");
			log.error("Error al crear propietarios: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<PropietarioResponseRest> actualizar(Propietarios propietario, Long id) {
		log.info("Inicio del metodo actualizar()");
		PropietarioResponseRest response = new PropietarioResponseRest();
		List<Propietarios> listPropietarios = new ArrayList<Propietarios>();
		try {
			Optional<Propietarios> propietarioBuscada = propietarioDao.findById(id);
			
			if(propietarioBuscada.isPresent()) {
				propietarioBuscada.get().setTipoPersonaPropietario(propietario.getTipoPersonaPropietario());
				propietarioBuscada.get().setDniPropietario(propietario.getDniPropietario());
				propietarioBuscada.get().setNombrePropietario(propietario.getNombrePropietario());
				propietarioBuscada.get().setApellidosPropietario(propietario.getApellidosPropietario());
				propietarioBuscada.get().setTipoViaPropietario(propietario.getTipoViaPropietario());
				propietarioBuscada.get().setDireccionPropietario(propietario.getDireccionPropietario());
				propietarioBuscada.get().setNumeroPropietario(propietario.getNumeroPropietario());
				propietarioBuscada.get().setPisoPropietario(propietario.getPisoPropietario());
				propietarioBuscada.get().setLetraPropietario(propietario.getLetraPropietario());
				propietarioBuscada.get().setCcPropietario(propietario.getCcPropietario());
				propietarioBuscada.get().setEmailPropietario(propietario.getEmailPropietario());
				propietarioBuscada.get().setMovilPropietario(propietario.getMovilPropietario());
				propietarioBuscada.get().setTelefonoPropietario(propietario.getTelefonoPropietario());
				
				Propietarios propietarioActualizar = propietarioDao.save(propietarioBuscada.get()); //actualizando
				if(propietarioActualizar != null) {
					response.setMetadata("Respuesta OK", "200", "Propietario actualizada");
					listPropietarios.add(propietarioActualizar);
					response.getPropietarioResponse().setPropietario(listPropietarios);
				}else {
					log.error("Error al actualizar la propietario");
					response.setMetadata("Respuesta KO", "400", "Propietario no actualizada");
					return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400
				}
			}else {
				log.error("Error al actualizar la propietario");
				response.setMetadata("Respuesta KO", "404", "Propietario no actualizada");
				return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al actualizar");
			log.error("Error al crear propietarios: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<PropietarioResponseRest> eliminar(Long id) {
		log.info("Inicio del metodo eliminar()");
		PropietarioResponseRest response = new PropietarioResponseRest();
		try {
			propietarioDao.deleteById(id);
			response.setMetadata("Respuesta OK", "200", "Propietario eliminada");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al eliminar");
			log.error("Error al eliminar propietarios: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<PropietarioResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}

}
