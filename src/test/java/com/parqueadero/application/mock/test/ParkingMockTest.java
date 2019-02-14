package com.parqueadero.application.mock.test;

import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.parqueadero.application.bussines.ParkingBussines;
import com.parqueadero.application.constantes.ConstantesTest;
import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.entity.Parking;
import com.parqueadero.application.service.ParkingService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class ParkingMockTest {
	
	@Mock
	private ParkingBussines bussines;
	

	@Test
	public void validarPlaca()  {
		
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.LUNES);
		
		Assert.assertFalse(bussines.validarPlaca("AXCD123"));
		
	}
	
	@Test
	public void obtenerDiaLunes()  {
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.LUNES);
		String dia = bussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.LUNES.equals(dia));
	}
	
	@Test
	public void obtenerDiaMartes()  {	
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.MARTES);
		String dia = bussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.MARTES.equals(dia));
	}
	
	@Test
	public void obtenerDiaMiercoles()  {	
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.MIERCOLES);
		String dia = bussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.MIERCOLES.equals(dia));
	}
	
	@Test
	public void obtenerDiaJueves()  {	
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.JUEVES);
		String dia = bussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.JUEVES.equals(dia));
	}
	
	@Test
	public void obtenerDiaViernes()  {	
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.VIERNES);
		String dia = bussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.VIERNES.equals(dia));
	}
	
	@Test
	public void obtenerDiaSabado()  {	
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.SABADO);
		String dia = bussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.SABADO.equals(dia));
	}
	
	@Test
	public void obtenerDiaDomingo()  {	
		when(bussines.obtenerDia()).thenReturn(ConstantesTest.DOMINGO);
		String dia = bussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.DOMINGO.equals(dia));
	}
	
}

