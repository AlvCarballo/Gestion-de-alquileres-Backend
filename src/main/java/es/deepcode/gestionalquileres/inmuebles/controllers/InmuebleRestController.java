/**
 * 
 */
package es.deepcode.gestionalquileres.inmuebles.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;
import es.deepcode.gestionalquileres.inmuebles.service.IInmuebleService;


/**
 * @author aocarballo
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class InmuebleRestController {
	
	
	@Autowired
	private IInmuebleService service;
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/inmuebles")
	public List<Inmuebles> findAll() {
		return service.findAll();
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/inmuebles/page/{page}")
	public Page<Inmuebles> findAll(@PathVariable Integer page) {
		return service.findAll(PageRequest.of(page, 10));
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/inmuebles/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Inmuebles inmueble= null;
		Map<String, Object> response = new HashMap<>();
		try {
			inmueble = service.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(inmueble == null) {
			response.put("mensaje", "La inmueble ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Inmuebles>(inmueble, HttpStatus.OK);
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/inmuebles")
	public ResponseEntity<?> save(@RequestBody Inmuebles request) {
		Inmuebles inmuebleNew= null;
		Map<String, Object> response = new HashMap<>();
		try {
			inmuebleNew = service.save(request);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La inmueble ha sido creado con éxito!");
		response.put("cliente", inmuebleNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PutMapping("/inmuebles/{id}")
	public ResponseEntity<?> update(@RequestBody Inmuebles request, @PathVariable Long id) {
		Inmuebles inmuebleActual = service.findById(id);
		Inmuebles inmuebleUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (inmuebleActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la inmueble ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			inmuebleActual.setLetra_inmueble(request.getLetra_inmueble());
			inmuebleActual.setPiso_inmueble(request.getLetra_inmueble());
			inmuebleActual.setRef_catastral_inmueble(request.getLetra_inmueble());
			inmuebleActual.setPrecio_inmueble(request.getPrecio_inmueble());
			inmuebleActual.setAlquilado_inmueble(request.isAlquilado_inmueble());
			inmuebleActual.setFinca(request.getFinca());
			inmuebleActual.setInquilino(request.getInquilino());
			inmuebleActual.setPropietario(request.getPropietario());

			inmuebleUpdated = service.update(request, id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la inmueble en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La inmueble ha sido actualizado con éxito!");
		response.put("cliente", inmuebleUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/inmuebles/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    service.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el inmueble de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La inmueble ha sido eliminada con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
