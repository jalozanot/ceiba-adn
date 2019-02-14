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
	
}

