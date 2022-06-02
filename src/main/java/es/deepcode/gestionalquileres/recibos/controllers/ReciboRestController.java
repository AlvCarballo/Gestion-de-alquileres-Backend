/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.deepcode.gestionalquileres.recibos.model.Recibos;
import es.deepcode.gestionalquileres.recibos.service.IReciboService;

/**
 * @author aocarballo
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class ReciboRestController {
	@Autowired
	private IReciboService service;
	
	@GetMapping("/recibos")
	public List<Recibos> findAll() {
		return service.findAll();
	}

	@GetMapping("/recibos/page/{page}")
	public Page<Recibos> findAll(@PathVariable Integer page) {
		return service.findAll(PageRequest.of(page, 10));
	}
	@GetMapping("/recibos/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Recibos recibo= null;
		Map<String, Object> response = new HashMap<>();
		try {
			recibo = service.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(recibo == null) {
			response.put("mensaje", "La recibo ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Recibos>(recibo, HttpStatus.OK);
	}
	
	@PostMapping("/recibos")
	public ResponseEntity<?> save(@RequestBody Recibos request) {
		Recibos reciboNew= null;
		Map<String, Object> response = new HashMap<>();
		try {
			reciboNew = service.save(request);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La recibo ha sido creado con éxito!");
		response.put("cliente", reciboNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@PutMapping("/recibos/{id}")
	public ResponseEntity<?> update(@RequestBody Recibos request, @PathVariable Long id) {
		Recibos reciboActual = service.findById(id);
		Recibos reciboUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (reciboActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la recibo ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			reciboActual.setImporte_recibo(request.getImporte_recibo());
			reciboActual.setConcepto_recibo(request.getConcepto_recibo());
			reciboActual.setFecha_recibo(request.getFecha_recibo());
			reciboActual.setInquilino(request.getInquilino());
			reciboActual.setInmueble(request.getInmueble());

			reciboUpdated = service.update(request, id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la recibo en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La recibo ha sido actualizado con éxito!");
		response.put("cliente", reciboUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	@DeleteMapping("/recibos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    service.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el recibo de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La recibo ha sido eliminada con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
