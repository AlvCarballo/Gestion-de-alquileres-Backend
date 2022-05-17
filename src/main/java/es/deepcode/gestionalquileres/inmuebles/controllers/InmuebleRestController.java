/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.controllers;

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

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;
import es.deepcode.gestionalquileres.inmuebles.response.InmuebleResponseRest;
import es.deepcode.gestionalquileres.inmuebles.service.IInmuebleService;


/**
 * @author aocarballo
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class InmuebleRestController {
	
	
	@Autowired
	private IInmuebleService service;
	
	@GetMapping("/inmuebles")
	public ResponseEntity<InmuebleResponseRest> consultarFinca() {
		ResponseEntity<InmuebleResponseRest> response = service.buscar();
		return response;
				
	}
	@GetMapping("/inmuebles/{id}")
	public ResponseEntity<InmuebleResponseRest> consultarFincaID(@PathVariable Long id) {
		ResponseEntity<InmuebleResponseRest> response = service.buscarID(id);
		return response;
				
	}
	@PostMapping("/inmuebles")
	public ResponseEntity<InmuebleResponseRest> crear(@RequestBody Inmuebles request) {
		ResponseEntity<InmuebleResponseRest> response = service.crear(request);
		return response;
	}
	@PutMapping("/inmuebles/{id}")
	public ResponseEntity<InmuebleResponseRest> actualizar(@RequestBody Inmuebles request, @PathVariable Long id) {
		ResponseEntity<InmuebleResponseRest> response = service.actualizar(request, id);
		return response;
	}
	@DeleteMapping("/inmuebles/{id}")
	public ResponseEntity<InmuebleResponseRest> eliminar(@PathVariable Long id) {
		ResponseEntity<InmuebleResponseRest> response = service.eliminar(id);
		return response;
	}
}
