package com.parqueadero.application.bussines;

import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.application.constantes.ConstantesTest;
import com.parqueadero.application.entity.Vigilante;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteBussinesTest {
	
	@Autowired
	VigilanteBussines vigilanteBussines;
	
	

	@Test
	public void obtenerAllVigilante() {
		
		List<Vigilante> respuesta = vigilanteBussines.getAllVigilante();
		Assert.assertTrue(Objects.nonNull(respuesta));
		
	}
	
	
	@Test
	public void obtenerByIdVigilante() {
		
		Vigilante answer = vigilanteBussines.getVigilanteId(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		Assert.assertTrue(Objects.nonNull(answer));
	
	}
	
	@Test
	public void guardarVigilante() {
		
		Vigilante vigilante = new Vigilante();
		vigilante.setIdVigilante(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		vigilante.setNombre(ConstantesTest.NOMBRE_VIGILANTE);
		vigilante.setApellido(ConstantesTest.APELLIDO_VIGILANTE);
		vigilante.setCedula(ConstantesTest.CEDULA_VIGILANTE);
		Vigilante answer = vigilanteBussines.saveVigilante(vigilante);
		Assert.assertTrue(Objects.nonNull(answer));
	
	}
	
	
}
