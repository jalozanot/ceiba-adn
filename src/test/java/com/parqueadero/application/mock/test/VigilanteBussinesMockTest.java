package com.parqueadero.application.mock.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.application.bussines.VigilanteBussines;
import com.parqueadero.application.constantes.ConstantesTest;
import com.parqueadero.application.entity.Vigilante;
import com.parqueadero.application.service.VigilanteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteBussinesMockTest {
	
	@MockBean
	private VigilanteService service;
	
	@Autowired
	private VigilanteBussines bussines;
	
	private Vigilante vigilanteDTO;
	
	@Before
	public void setup() {
		
		MockitoAnnotations.initMocks(this);
		Vigilante vigilante = new Vigilante();
		vigilante.setIdVigilante(Long.parseLong(ConstantesTest.ID_VIGILANTE_PRUEBA));
		vigilante.setApellido(ConstantesTest.APELLIDO_VIGILANTE);
		vigilante.setNombre(ConstantesTest.NOMBRE_VIGILANTE);
		vigilante.setCedula(ConstantesTest.CEDULA_VIGILANTE);
		vigilanteDTO = vigilante;
	}
	
	
	@Test
	public void verifyCreate()  {
		
		when(service.saveOrUpdateVigilante(vigilanteDTO)).thenReturn(vigilanteDTO);
		Vigilante respuesta = bussines.saveVigilante(vigilanteDTO);
		Assert.assertTrue(respuesta.getIdVigilante().toString().equals(ConstantesTest.ID_VIGILANTE_PRUEBA));
		
	}
	
}
