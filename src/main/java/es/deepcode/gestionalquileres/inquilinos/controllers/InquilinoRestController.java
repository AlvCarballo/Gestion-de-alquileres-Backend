/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.controllers;

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

import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;
import es.deepcode.gestionalquileres.inquilinos.response.InquilinoResponseRest;
import es.deepcode.gestionalquileres.inquilinos.service.IInquilinoService;

/**
 * @author aocarballo
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class InquilinoRestController {
	@Autowired
	private IInquilinoService service;
	
	@GetMapping("/inquilinos")
	public ResponseEntity<InquilinoResponseRest> consultarFinca() {
		ResponseEntity<InquilinoResponseRest> response = service.buscar();
		return response;
				
	}
	@GetMapping("/inquilinos/{id}")
	public ResponseEntity<InquilinoResponseRest> consultarFincaID(@PathVariable Long id) {
		ResponseEntity<InquilinoResponseRest> response = service.buscarID(id);
		return response;
				
	}
	@PostMapping("/inquilinos")
	public ResponseEntity<InquilinoResponseRest> crear(@RequestBody Inquilinos request) {
		ResponseEntity<InquilinoResponseRest> response = service.crear(request);
		return response;
	}
	@PutMapping("/inquilinos/{id}")
	public ResponseEntity<InquilinoResponseRest> actualizar(@RequestBody Inquilinos request, @PathVariable Long id) {
		ResponseEntity<InquilinoResponseRest> response = service.actualizar(request, id);
		return response;
	}
	@DeleteMapping("/inquilinos/{id}")
	public ResponseEntity<InquilinoResponseRest> eliminar(@PathVariable Long id) {
		ResponseEntity<InquilinoResponseRest> response = service.eliminar(id);
		return response;
	}
}
