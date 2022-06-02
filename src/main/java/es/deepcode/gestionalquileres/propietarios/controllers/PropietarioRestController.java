/**
 * 
 */
package es.deepcode.gestionalquileres.propietarios.controllers;

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

import es.deepcode.gestionalquileres.propietarios.model.Propietarios;
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
	public List<Propietarios> findAll() {
		return service.findAll();
	}

	@GetMapping("/propietarios/page/{page}")
	public Page<Propietarios> findAll(@PathVariable Integer page) {
		return service.findAll(PageRequest.of(page, 10));
	}
	@GetMapping("/propietarios/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Propietarios propietario= null;
		Map<String, Object> response = new HashMap<>();
		try {
			propietario = service.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(propietario == null) {
			response.put("mensaje", "La propietario ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Propietarios>(propietario, HttpStatus.OK);
	}
	
	@PostMapping("/propietarios")
	public ResponseEntity<?> save(@RequestBody Propietarios request) {
		Propietarios propietarioNew= null;
		Map<String, Object> response = new HashMap<>();
		try {
			propietarioNew = service.save(request);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La propietario ha sido creado con éxito!");
		response.put("cliente", propietarioNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	@PutMapping("/propietarios/{id}")
	public ResponseEntity<?> update(@RequestBody Propietarios request, @PathVariable Long id) {
		Propietarios propietarioActual = service.findById(id);
		Propietarios propietarioUpdated = null;
		
		Map<String, Object> response = new HashMap<>();
		
		if (propietarioActual == null) {
			response.put("mensaje", "Error: no se pudo editar, la propietario ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			propietarioActual.setTipo_persona_propietario(request.getTipo_persona_propietario());
			propietarioActual.setDni_propietario(request.getDni_propietario());
			propietarioActual.setNombre_propietario(request.getNombre_propietario());
			propietarioActual.setApellidos_propietario(request.getApellidos_propietario());
			propietarioActual.setTipo_via_propietario(request.getTipo_via_propietario());
			propietarioActual.setDireccion_propietario(request.getDireccion_propietario());
			propietarioActual.setNumero_propietario(request.getNumero_propietario());
			propietarioActual.setPiso_propietario(request.getPiso_propietario());
			propietarioActual.setLetra_propietario(request.getLetra_propietario());
			propietarioActual.setCc_propietario(request.getCc_propietario());
			propietarioActual.setEmail_propietario(request.getEmail_propietario());
			propietarioActual.setMovil_propietario(request.getMovil_propietario());
			propietarioActual.setTelefono_propietario(request.getTelefono_propietario());
			
			propietarioUpdated = service.update(request, id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la propietario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La propietario ha sido actualizado con éxito!");
		response.put("cliente", propietarioUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		
	}
	@DeleteMapping("/propietarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
		    service.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el propietario de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La propietario ha sido eliminada con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
