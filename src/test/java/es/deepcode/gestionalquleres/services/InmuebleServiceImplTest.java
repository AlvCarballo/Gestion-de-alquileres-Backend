/**
 * 
 */
package es.deepcode.gestionalquleres.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import es.deepcode.gestionalquileres.fincas.model.Fincas;
import es.deepcode.gestionalquileres.inmuebles.dao.IInmuebleDao;
import es.deepcode.gestionalquileres.inmuebles.model.Inmuebles;
import es.deepcode.gestionalquileres.inmuebles.response.InmuebleResponseRest;
import es.deepcode.gestionalquileres.inmuebles.service.InmuebleServiceImpl;
import es.deepcode.gestionalquileres.inquilinos.model.Inquilinos;
import es.deepcode.gestionalquileres.propietarios.model.Propietarios;

/**
 * @author aocarballo
 *
 */
public class InmuebleServiceImplTest {
	@InjectMocks
	InmuebleServiceImpl service;
	@Mock
	IInmuebleDao inmuebleDao;

	List<Inmuebles> list = new ArrayList<Inmuebles>();
	List<Inmuebles> list2 = new ArrayList<Inmuebles>();

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.cargarInmuebles();
	}

	@Test
	public void buscarTest() {
		when(inmuebleDao.findAll()).thenReturn(list);
		ResponseEntity<InmuebleResponseRest> response = service.buscar();
		assertEquals(4, response.getBody().getInmuebleResponse().getInmueble().size());
		verify(inmuebleDao, times(1)).findAll();
	}

	@Test
	public void buscarIDTest() {
		Inmuebles inmueble = new Inmuebles();
		inmueble.setid(Long.valueOf(1));

		when(inmuebleDao.findById(inmueble.getid())).thenReturn(Optional.of(inmueble));

		ResponseEntity<InmuebleResponseRest> response = service.buscarID(inmueble.getid());
		assertEquals(1, response.getBody().getInmuebleResponse().getInmueble().size());
		verify(inmuebleDao).findById(inmueble.getid());
	}

	 @Test
	    public void crearTest() {
		 Inmuebles inmueble = new Inmuebles();
		 inmueble.setid(Long.valueOf(1));
			inmueble.setRefCatastralInmueble("Test Name");
			inmueble.setPisoInmueble("Bajo");
			inmueble.setLetraInmueble("A");
			inmueble.setPropietario(
					new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0));
			inmueble.setFinca(new Fincas(Long.valueOf(1), null));
			inmueble.setInquilino(
					new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));
			

	        when(inmuebleDao.save(ArgumentMatchers.any(Inmuebles.class))).thenReturn(inmueble);

	        ResponseEntity<InmuebleResponseRest> respuesta = service.crear(inmueble);

	        assertThat(respuesta.getStatusCodeValue()).isEqualTo(200);
	        
	    }
	
	@Test
	public void actualizarTest() {
		Inmuebles inmueble = new Inmuebles();
		inmueble.setid(Long.valueOf(1));
		inmueble.setRefCatastralInmueble("Test Name");
		inmueble.setPisoInmueble("Bajo");
		inmueble.setLetraInmueble("A");
		inmueble.setPropietario(
				new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0));
		inmueble.setFinca(new Fincas(Long.valueOf(1), null));
		inmueble.setInquilino(
				new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));
		
		
		Inmuebles newInmueble = new Inmuebles();
		newInmueble.setRefCatastralInmueble("Test Name");
		newInmueble.setPisoInmueble("Bajo");
		newInmueble.setLetraInmueble("B");
		newInmueble.setPropietario(
				new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0));
		newInmueble.setFinca(new Fincas(Long.valueOf(1), null));
		newInmueble.setInquilino(
				new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));

		ResponseEntity<InmuebleResponseRest> respuesta = service.actualizar(newInmueble, inmueble.getid());

		assertThat(respuesta.getStatusCodeValue()).isEqualTo(200);
	}

	public void cargarInmuebles() {
		Inmuebles inmuebleUno = new Inmuebles(Long.valueOf(1), "TG234 43242 424234224", "Bajo", "A",
				new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0),
				new Fincas(Long.valueOf(1), null),
				new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));
		Inmuebles inmuebleDos = new Inmuebles(Long.valueOf(2), "TG234 43242 424234227", "1", "A",
				new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0),
				new Fincas(Long.valueOf(1), null),
				new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));
		Inmuebles inmuebleTres = new Inmuebles(Long.valueOf(3), "TG234 43242 424234226", "2", "A",
				new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0),
				new Fincas(Long.valueOf(1), null),
				new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));
		Inmuebles inmuebleCuatro = new Inmuebles(Long.valueOf(4), "TG234 43242 424234225", "Atico", "A",
				new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0),
				new Fincas(Long.valueOf(1), null),
				new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));

		list.add(inmuebleUno);
		list.add(inmuebleDos);
		list.add(inmuebleTres);
		list.add(inmuebleCuatro);

		Inmuebles inmuebleID = new Inmuebles(Long.valueOf(1), "TG234 43242 424234225", "Atico", "A",
				new Propietarios(Long.valueOf(1), null, null, null, null, null, null, 0, null, null, null, null, 0, 0),
				new Fincas(Long.valueOf(1), null),
				new Inquilinos(Long.valueOf(1), null, null, null, null, null, 0, null, null, null, null, 0, 0));
		list2.add(inmuebleID);
	}
}
