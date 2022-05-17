/**
 * 
 */
package es.deepcode.gestionalquleres.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.fincas.dao.IFincaDao;
import es.deepcode.gestionalquileres.fincas.model.Fincas;
import es.deepcode.gestionalquileres.fincas.response.FincaResponseRest;
import es.deepcode.gestionalquileres.fincas.service.FincaServiceImpl;

/**
 * @author aocarballo
 *
 */
public class FincasServicesImplTest {
	@InjectMocks
	FincaServiceImpl service;
	@Mock
	IFincaDao fincaDao;
	
	List<Fincas> list = new ArrayList<Fincas>();
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.cargarFincas();
	}
	@Test
	public void buscarTest() {
		when(fincaDao.findAll()).thenReturn(list);
		ResponseEntity<FincaResponseRest> response = service.buscar();
		assertEquals(4, response.getBody().getFincaResponse().getFinca().size());
		verify(fincaDao, times(1)).findAll();
	}
	
	public void cargarFincas() {
		Fincas fincaUno = new Fincas(Long.valueOf(1), "Valle 5");
		Fincas fincaDos = new Fincas(Long.valueOf(2), "Valle 7");
		Fincas fincaTres = new Fincas(Long.valueOf(3), "Alhondiga 5");
		Fincas fincaCuatro = new Fincas(Long.valueOf(4), "Procurador 7");
		
		list.add(fincaUno);
		list.add(fincaDos);
		list.add(fincaTres);
		list.add(fincaCuatro);
	}
}
