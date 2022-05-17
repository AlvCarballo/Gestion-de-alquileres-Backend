/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.service;


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

import es.deepcode.gestionalquileres.inquilinos.dao.IInquilinoDao;
import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;
import es.deepcode.gestionalquileres.inquilinos.response.InquilinoResponseRest;

/**
 * @author aocarballo
 *
 */
@Service
public class InquilinoServiceImpl implements IInquilinoService{
	private static final Logger log = LoggerFactory.getLogger(InquilinoServiceImpl.class);
	@Autowired
	private IInquilinoDao inquilinoDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<InquilinoResponseRest> buscar() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarInquilinos()");
		InquilinoResponseRest response = new InquilinoResponseRest();
		try {
			List<Inquilinos> listInquilinos = (List<Inquilinos>) inquilinoDao.findAll();
			response.getInquilinoResponse().setInquilino(listInquilinos);
			response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar inquilinos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<InquilinoResponseRest> buscarID(Long id) {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarInquilinosID()");
		InquilinoResponseRest response = new InquilinoResponseRest();
		List<Inquilinos> listInquilinos = new ArrayList<Inquilinos>();
		try {
			Optional<Inquilinos> inquilino = inquilinoDao.findById(id);
			if(inquilino.isPresent()) {
				listInquilinos.add(inquilino.get());
				response.getInquilinoResponse().setInquilino(listInquilinos);
				response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
			}else {
				log.error("Inquilino no emcontrada");
				response.setMetadata("Respuesta KO", "404", "Inquilino no encontrada");
				return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar inquilinos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<InquilinoResponseRest> crear(Inquilinos inquilino) {
		log.info("Inicio del metodo crear()");
		InquilinoResponseRest response = new InquilinoResponseRest();
		List<Inquilinos> listInquilinos = new ArrayList<Inquilinos>();
		try {
			Inquilinos inquilinoGuardada = inquilinoDao.save(inquilino);
			if(inquilinoGuardada != null) {
				listInquilinos.add(inquilino);
				response.getInquilinoResponse().setInquilino(listInquilinos);
				response.setMetadata("Respuesta OK", "200", "Inquilino guardada");
			}else {
				log.error("Error al guardar la inquilino");
				response.setMetadata("Respuesta KO", "400", "Inquilino no guardada");
				return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400.
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al guardar");
			log.error("Error al crear inquilinos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<InquilinoResponseRest> actualizar(Inquilinos inquilino, Long id) {
		log.info("Inicio del metodo actualizar()");
		InquilinoResponseRest response = new InquilinoResponseRest();
		List<Inquilinos> listInquilinos = new ArrayList<Inquilinos>();
		try {
			Optional<Inquilinos> inquilinoBuscada = inquilinoDao.findById(id);
			
			if(inquilinoBuscada.isPresent()) {
				inquilinoBuscada.get().setDniInquilino(inquilino.getDniInquilino());
				inquilinoBuscada.get().setNombreInquilino(inquilino.getNombreInquilino());
				inquilinoBuscada.get().setApellidosInquilino(inquilino.getApellidosInquilino());
				inquilinoBuscada.get().setTipoViaInquilino(inquilino.getTipoViaInquilino());
				inquilinoBuscada.get().setDireccionInquilino(inquilino.getDireccionInquilino());
				inquilinoBuscada.get().setNumeroInquilino(inquilino.getNumeroInquilino());
				inquilinoBuscada.get().setPisoInquilino(inquilino.getPisoInquilino());
				inquilinoBuscada.get().setLetraInquilino(inquilino.getLetraInquilino());
				inquilinoBuscada.get().setCcInquilino(inquilino.getCcInquilino());
				inquilinoBuscada.get().setEmailInquilino(inquilino.getEmailInquilino());
				inquilinoBuscada.get().setMovilInquilino(inquilino.getMovilInquilino());
				inquilinoBuscada.get().setTelefonoInquilino(inquilino.getTelefonoInquilino());
				
				Inquilinos inquilinoActualizar = inquilinoDao.save(inquilinoBuscada.get()); //actualizando
				if(inquilinoActualizar != null) {
					response.setMetadata("Respuesta OK", "200", "Inquilino actualizada");
					listInquilinos.add(inquilinoActualizar);
					response.getInquilinoResponse().setInquilino(listInquilinos);
				}else {
					log.error("Error al actualizar la inquilino");
					response.setMetadata("Respuesta KO", "400", "Inquilino no actualizada");
					return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400
				}
			}else {
				log.error("Error al actualizar la inquilino");
				response.setMetadata("Respuesta KO", "404", "Inquilino no actualizada");
				return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al actualizar");
			log.error("Error al crear inquilinos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<InquilinoResponseRest> eliminar(Long id) {
		log.info("Inicio del metodo eliminar()");
		InquilinoResponseRest response = new InquilinoResponseRest();
		try {
			inquilinoDao.deleteById(id);
			response.setMetadata("Respuesta OK", "200", "Inquilino eliminada");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al eliminar");
			log.error("Error al eliminar inquilinos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<InquilinoResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}

}
