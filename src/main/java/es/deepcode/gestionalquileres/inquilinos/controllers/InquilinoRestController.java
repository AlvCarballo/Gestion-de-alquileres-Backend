/**
 * 
 */
package es.deepcode.gestionalquileres.inquilinos.controllers;

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

import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;
import es.deepcode.gestionalquileres.inquilinos.service.IInquilinoService;

/**
 * @author aocarballo
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class InquilinoRestController {
	@Autowired
	private IInquilinoService service;
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/inquilinos")
	public List<Inquilinos> findAll() {
		return service.findAll();
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/inquilinos/page/{page}")
	public Page<Inquilinos> findAll(@PathVariable Integer page) {
		return service.findAll(PageRequest.of(page, 10));
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping("/inquilinos/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Inquilinos inquilino= null;
		Map<String, Object> response = new HashMap<>();
		try {
			inquilino = service.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(inquilino == null) {
			response.put("mensaje", "La inquilino ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Inquilinos>(inquilino, HttpStatus.OK);
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping("/inquilinos")
	public ResponseEntity<?> save(@RequestBody Inquilinos request) {
		Inquilinos inquilinoNew= null;
		Map<String, Object> response = new HashMap<>();
		try {
			inquilinoNew = service.save(request);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La inquilino ha sido creado con éxito!");
		response.put("cliente", inquilinoNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PutMapping("/inquilinos/{id}")
	public ResponseEntity<?> update(@RequestBody Inquilinos request, @PathVariable Long id) {
		Inquilinos inquilinoActual = service.findById(id);
		Inquilinos inquilinoUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (inquilinoActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la inquilino ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			inquilinoActual.setApellidos_inquilino(request.getApellidos_inquilino());
			inquilinoActual.setCc_inquilino(request.getCc_inquilino());
			inquilinoActual.setDireccion_inquilino(request.getDireccion_inquilino());
			inquilinoActual.setDni_inquilino(request.getDni_inquilino());
			inquilinoActual.setEmail_inquilino(request.getEmail_inquilino());
			inquilinoActual.setLetra_inquilino(request.getLetra_inquilino());
			inquilinoActual.setMovil_inquilino(request.getMovil_inquilino());
			inquilinoActual.setNombre_inquilino(request.getNombre_inquilino());
			inquilinoActual.setNumero_inquilino(request.getNumero_inquilino());
			inquilinoActual.setPiso_inquilino(request.getPiso_inquilino());
			inquilinoActual.setTelefono_inquilino(request.getTelefono_inquilino());
			inquilinoActual.setTipo_via_inquilino(request.getTipo_via_inquilino());

			inquilinoUpdated = service.update(request, id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la inquilino en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La inquilino ha sido actualizado con éxito!");
		response.put("cliente", inquilinoUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	@Secured({"ROLE_ADMIN"})
	@DeleteMapping("/inquilinos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    service.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el inquilino de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La inquilino ha sido eliminada con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
