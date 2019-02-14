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
import com.parqueadero.application.constantes.ConstantesVal;
import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.entity.Parking;
import com.parqueadero.application.service.ParkingService;


@RunWith(MockitoJUnitRunner.Silent.class)
public class ParkingMockTest {
	
	@Mock
	private ParkingBussines bussines;
	

	@Test
	public void validarPlaca()  {
		
		when(bussines.obtenerDia()).thenReturn(ConstantesVal.LUNES);
		
		Assert.assertFalse(bussines.validarPlaca("AXCD123"));
		
	}
	
//	@Test
//	public void obtenerDiaLunes()  {
//		when(bussines.obtenerDia()).thenReturn(ConstantesVal.LUNES);
//		String dia = bussines.obtenerDia();
//		Assert.assertTrue(ConstantesVal.LUNES.equals(dia));
//	}
//	
//	@Test
//	public void obtenerDiaMartes()  {	
//		when(bussines.obtenerDia()).thenReturn(ConstantesVal.MARTES);
//		String dia = bussines.obtenerDia();
//		Assert.assertTrue(ConstantesVal.MARTES.equals(dia));
//	}
//	
//	@Test
//	public void obtenerDiaMiercoles()  {	
//		when(bussines.obtenerDia()).thenReturn(ConstantesVal.MIERCOLES);
//		String dia = bussines.obtenerDia();
//		Assert.assertTrue(ConstantesVal.MIERCOLES.equals(dia));
//	}
//	
//	@Test
//	public void obtenerDiaJueves()  {	
//		when(bussines.obtenerDia()).thenReturn(ConstantesVal.JUEVES);
//		String dia = bussines.obtenerDia();
//		Assert.assertTrue(ConstantesVal.JUEVES.equals(dia));
//	}
//	
//	@Test
//	public void obtenerDiaViernes()  {	
//		when(bussines.obtenerDia()).thenReturn(ConstantesVal.VIERNES);
//		String dia = bussines.obtenerDia();
//		Assert.assertTrue(ConstantesVal.VIERNES.equals(dia));
//	}
//	
//	@Test
//	public void obtenerDiaSabado()  {	
//		when(bussines.obtenerDia()).thenReturn(ConstantesVal.SABADO);
//		String dia = bussines.obtenerDia();
//		Assert.assertTrue(ConstantesVal.SABADO.equals(dia));
//	}
//	
//	@Test
//	public void obtenerDiaDomingo()  {	
//		when(bussines.obtenerDia()).thenReturn(ConstantesVal.DOMINGO);
//		String dia = bussines.obtenerDia();
//		Assert.assertTrue(ConstantesVal.DOMINGO.equals(dia));
//	}
	
}

