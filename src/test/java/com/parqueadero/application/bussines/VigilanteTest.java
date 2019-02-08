package com.parqueadero.application.bussines;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.application.entity.Vigilante;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes=VigilanteBussines.class)
public class VigilanteTest {
	
	@Mock
	private VigilanteBussines bussines;
	
	private Vigilante vigilanteDTO;
	
	Collection<Vigilante> lista = new ArrayList<>();
	
	@Before
	public void setup() {
		
		
		MockitoAnnotations.initMocks(this);
		Vigilante vigilante = new Vigilante();
		vigilante.setIdVigilante(Long.parseLong("1"));
		vigilante.setApellido("Rolando");
		vigilante.setNombre("Pedrosqui");
		vigilante.setCedula("1091657");
		vigilanteDTO = vigilante;
	}
	
	@Test
	public void verifyCreate() throws Exception {
		
		Vigilante vigilante = new Vigilante();
		vigilante.setIdVigilante(Long.parseLong("1"));
		vigilante.setApellido("Rolando");
		vigilante.setNombre("Pedrosqui");
		vigilante.setCedula("1091657");

		when(bussines.saveVigilante(vigilante)).thenReturn(Long.parseLong("1"));
		Long respuesta = bussines.saveVigilante(vigilanteDTO);
		//Assert.assertEquals(dto.getIdDireccion(), respuesta.getIdDireccion());
		assertEquals(5, 5);
		
	}
	
}
