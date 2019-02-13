package com.parqueadero.application.mock.test;

import static org.mockito.Mockito.when;

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
public class ParkingBussinesMockTest {
	
	@InjectMocks
	private ParkingBussines bussines;
	
	@Mock
	private ParkingService service;
	
	
	
	private Parking parkingEntityMoto;
	private Parking parkingEntityCarro;
	private ParkingDTO parkingMoto;
	private ParkingDTO parkingCarro;

	
	@Before
	public void setupEntity() {
		
		MockitoAnnotations.initMocks(this);
		Parking parkingMoto = new Parking();
		parkingMoto.setIdParking(Long.parseLong(ConstantesTest.ID_PARKING_MOTO));
		parkingMoto.setIdVigilante(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		parkingMoto.setNumPlaca(ConstantesTest.NUM_PLACA);
		parkingMoto.setCilindrajeVehiculo(ConstantesTest.CILINDRAJE_VEHICULO);
		parkingMoto.setTipoVehiculo(ConstantesTest.TIPO_VEHICULO_MOTO);
		parkingMoto.setPuesto(Integer.parseInt(ConstantesTest.PUESTO));
		parkingMoto.setEstado(ConstantesTest.ESTADO_INGRESO);
		parkingEntityMoto = parkingMoto;
		
	}
	
	@Before
	public void setupDTO() {
		
		ParkingDTO parkingMotoDTO = new ParkingDTO();
		parkingMotoDTO.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
		parkingMotoDTO.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
		parkingMotoDTO.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
		parkingMoto = parkingMotoDTO;
		
	}
	
	
	@Test
	public void saveParkingMoto()  {
		
		when(service.saveOrUpdateParking(Mockito.anyObject())).thenReturn(parkingEntityMoto);
		ParkingDTO parkMoto = bussines.saveParking(parkingMoto);
		Assert.assertTrue(Objects.nonNull(parkMoto));
		
	}
	

	
}
