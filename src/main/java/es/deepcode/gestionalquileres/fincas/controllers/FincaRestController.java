/**
 * 
 */
package es.deepcode.gestionalquileres.fincas.controllers;

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

import es.deepcode.gestionalquileres.fincas.model.Fincas;
import es.deepcode.gestionalquileres.fincas.response.FincaResponseRest;
import es.deepcode.gestionalquileres.fincas.service.IFincaService;

/**
 * @author aocarballo
 *
 */

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class FincaRestController {
	@Autowired
	private IFincaService service;
	@GetMapping("/fincas")
	public ResponseEntity<FincaResponseRest> consultarFinca() {
		ResponseEntity<FincaResponseRest> response = service.buscar();
		return response;
				
	}
	@GetMapping("/fincas/{id}")
	public ResponseEntity<FincaResponseRest> consultarFincaID(@PathVariable Long id) {
		ResponseEntity<FincaResponseRest> response = service.buscarID(id);
		return response;
				
	}
	@PostMapping("/fincas")
	public ResponseEntity<FincaResponseRest> crear(@RequestBody Fincas request) {
		ResponseEntity<FincaResponseRest> response = service.crear(request);
		return response;
	}
	@PutMapping("/fincas/{id}")
	public ResponseEntity<FincaResponseRest> actualizar(@RequestBody Fincas request, @PathVariable Long id) {
		ResponseEntity<FincaResponseRest> response = service.actualizar(request, id);
		return response;
	}
	@DeleteMapping("/fincas/{id}")
	public ResponseEntity<FincaResponseRest> eliminar(@PathVariable Long id) {
		ResponseEntity<FincaResponseRest> response = service.eliminar(id);
		return response;
	}
}
