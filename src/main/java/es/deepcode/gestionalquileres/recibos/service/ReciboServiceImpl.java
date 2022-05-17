/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.service;

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

import es.deepcode.gestionalquileres.recibos.dao.IReciboDao;
import es.deepcode.gestionalquileres.recibos.model.Recibos;
import es.deepcode.gestionalquileres.recibos.response.ReciboResponseRest;

/**
 * @author aocarballo
 *
 */
@Service
public class ReciboServiceImpl implements IReciboService{
	private static final Logger log = LoggerFactory.getLogger(ReciboServiceImpl.class);
	@Autowired
	private IReciboDao reciboDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<ReciboResponseRest> buscar() {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarRecibos()");
		ReciboResponseRest response = new ReciboResponseRest();
		try {
			List<Recibos> listRecibos = (List<Recibos>) reciboDao.findAll();
			response.getReciboResponse().setRecibo(listRecibos);
			response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar recibos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<ReciboResponseRest> buscarID(Long id) {
		// TODO Auto-generated method stub
		log.info("Inicio del metodo buscarRecibosID()");
		ReciboResponseRest response = new ReciboResponseRest();
		List<Recibos> listRecibos = new ArrayList<Recibos>();
		try {
			Optional<Recibos> recibo = reciboDao.findById(id);
			if(recibo.isPresent()) {
				listRecibos.add(recibo.get());
				response.getReciboResponse().setRecibo(listRecibos);
				response.setMetadata("Respuesta OK", "200", "Respuesta exitosa");
			}else {
				log.error("Recibo no emcontrada");
				response.setMetadata("Respuesta KO", "404", "Recibo no encontrada");
				return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al consultar");
			log.error("Error al consultar recibos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<ReciboResponseRest> crear(Recibos recibo) {
		log.info("Inicio del metodo crear()");
		ReciboResponseRest response = new ReciboResponseRest();
		List<Recibos> listRecibos = new ArrayList<Recibos>();
		try {
			Recibos reciboGuardada = reciboDao.save(recibo);
			if(reciboGuardada != null) {
				listRecibos.add(recibo);
				response.getReciboResponse().setRecibo(listRecibos);
				response.setMetadata("Respuesta OK", "200", "Recibo guardada");
			}else {
				log.error("Error al guardar la recibo");
				response.setMetadata("Respuesta KO", "400", "Recibo no guardada");
				return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400.
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al guardar");
			log.error("Error al crear recibos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<ReciboResponseRest> actualizar(Recibos recibo, Long id) {
		log.info("Inicio del metodo actualizar()");
		ReciboResponseRest response = new ReciboResponseRest();
		List<Recibos> listRecibos = new ArrayList<Recibos>();
		try {
			Optional<Recibos> reciboBuscada = reciboDao.findById(id);
			
			if(reciboBuscada.isPresent()) {
				reciboBuscada.get().setImporteRecibo(recibo.getImporteRecibo());
				reciboBuscada.get().setConceptoRecibo(recibo.getConceptoRecibo());
				reciboBuscada.get().setFechaRecibo(recibo.getFechaRecibo());
				reciboBuscada.get().setInquilino(recibo.getInquilino());
				reciboBuscada.get().setInmueble(recibo.getInmueble());

				Recibos reciboActualizar = reciboDao.save(reciboBuscada.get()); //actualizando
				if(reciboActualizar != null) {
					response.setMetadata("Respuesta OK", "200", "Recibo actualizada");
					listRecibos.add(reciboActualizar);
					response.getReciboResponse().setRecibo(listRecibos);
				}else {
					log.error("Error al actualizar la recibo");
					response.setMetadata("Respuesta KO", "400", "Recibo no actualizada");
					return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.BAD_REQUEST); //Devuelve 400
				}
			}else {
				log.error("Error al actualizar la recibo");
				response.setMetadata("Respuesta KO", "404", "Recibo no actualizada");
				return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.NOT_FOUND); //Devuelve 404
			}
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al actualizar");
			log.error("Error al crear recibos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}
	@Override
	@Transactional
	public ResponseEntity<ReciboResponseRest> eliminar(Long id) {
		log.info("Inicio del metodo eliminar()");
		ReciboResponseRest response = new ReciboResponseRest();
		try {
			reciboDao.deleteById(id);
			response.setMetadata("Respuesta OK", "200", "Recibo eliminada");
		} catch (Exception e) {
			// TODO: handle exception
			response.setMetadata("Respuesta KO", "500", "Error al eliminar");
			log.error("Error al eliminar recibos: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR); //Devuelve 500
		}
		return new ResponseEntity<ReciboResponseRest>(response, HttpStatus.OK); //Devuelve 200
	}

}
