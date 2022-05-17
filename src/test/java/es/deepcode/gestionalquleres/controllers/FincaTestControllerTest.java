/**
 * 
 */
package es.deepcode.gestionalquleres.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import es.deepcode.gestionalquileres.fincas.controllers.FincaRestController;
import es.deepcode.gestionalquileres.fincas.model.Fincas;
import es.deepcode.gestionalquileres.fincas.response.FincaResponseRest;
import es.deepcode.gestionalquileres.fincas.service.IFincaService;

/**
 * @author aocarballo
 *
 */
public class FincaTestControllerTest {
	@InjectMocks
	FincaRestController fincaController;
	
	@Mock
	private IFincaService service;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void crearTest() {
		
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Fincas finca = new Fincas(Long.valueOf(1), "Valle 7");
		
		when(service.crear(any(Fincas.class))).thenReturn(new ResponseEntity<FincaResponseRest>(HttpStatus.OK));
		
		ResponseEntity<FincaResponseRest> respuesta = fincaController.crear(finca);
		
		assertThat(respuesta.getStatusCodeValue()).isEqualTo(200);
		
	}
}
