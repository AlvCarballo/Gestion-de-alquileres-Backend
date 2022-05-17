/**
 * 
 */
package es.deepcode.gestionalquileres.recibos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
import es.deepcode.gestionalquileres.recibos.response.ReciboResponseRest;
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
	public ResponseEntity<ReciboResponseRest> consultar() {
		ResponseEntity<ReciboResponseRest> response = service.buscar();
		return response;
				
	}
	@GetMapping("/recibos/{id}")
	public ResponseEntity<ReciboResponseRest> consultarID(@PathVariable Long id) {
		ResponseEntity<ReciboResponseRest> response = service.buscarID(id);
		return response;
				
	}
	@PostMapping("/recibos")
	public ResponseEntity<ReciboResponseRest> crear(@RequestBody Recibos request) {
		ResponseEntity<ReciboResponseRest> response = service.crear(request);
		return response;
	}
	@PutMapping("/recibos/{id}")
	public ResponseEntity<ReciboResponseRest> actualizar(@RequestBody Recibos request, @PathVariable Long id) {
		ResponseEntity<ReciboResponseRest> response = service.actualizar(request, id);
		return response;
	}
	@DeleteMapping("/recibos/{id}")
	public ResponseEntity<ReciboResponseRest> eliminar(@PathVariable Long id) {
		ResponseEntity<ReciboResponseRest> response = service.eliminar(id);
		return response;
	}
}
