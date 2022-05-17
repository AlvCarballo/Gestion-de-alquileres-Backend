/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.controllers;

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

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;
import es.deepcode.gestionalquileres.propietarios.response.PropietarioResponseRest;
import es.deepcode.gestionalquileres.propietarios.service.IPropietarioService;

/**
 * @author aocarballo
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.HEAD})
public class PropietarioRestController {
	@Autowired
	private IPropietarioService service;
	
	@GetMapping("/propietarios")
	public ResponseEntity<PropietarioResponseRest> consultarFinca() {
		ResponseEntity<PropietarioResponseRest> response = service.buscar();
		return response;
				
	}
	@GetMapping("/propietarios/{id}")
	public ResponseEntity<PropietarioResponseRest> consultarFincaID(@PathVariable Long id) {
		ResponseEntity<PropietarioResponseRest> response = service.buscarID(id);
		return response;
				
	}
	@PostMapping("/propietarios")
	public ResponseEntity<PropietarioResponseRest> crear(@RequestBody Propietarios request) {
		ResponseEntity<PropietarioResponseRest> response = service.crear(request);
		return response;
	}
	@PutMapping("/propietarios/{id}")
	public ResponseEntity<PropietarioResponseRest> actualizar(@RequestBody Propietarios request, @PathVariable Long id) {
		ResponseEntity<PropietarioResponseRest> response = service.actualizar(request, id);
		return response;
	}
	@DeleteMapping("/propietarios/{id}")
	public ResponseEntity<PropietarioResponseRest> eliminar(@PathVariable Long id) {
		ResponseEntity<PropietarioResponseRest> response = service.eliminar(id);
		return response;
	}
}
