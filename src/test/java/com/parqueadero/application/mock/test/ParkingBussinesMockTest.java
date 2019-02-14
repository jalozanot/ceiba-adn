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
		parkingMoto.setFechaIngreso(new Date(1000));
		parkingMoto.setFechaSalida(new Date(100000));
		parkingMoto.setNumPlaca(ConstantesTest.NUM_PLACA);
		parkingMoto.setCilindrajeVehiculo(ConstantesTest.CILINDRAJE_VEHICULO);
		parkingMoto.setTipoVehiculo(ConstantesTest.TIPO_VEHICULO_MOTO);
		parkingMoto.setPuesto(Integer.parseInt(ConstantesTest.PUESTO));
		parkingMoto.setEstado(ConstantesTest.ESTADO_INGRESO);
		parkingEntityMoto = parkingMoto;
		
		Parking parkingCarro = new Parking();
		parkingCarro.setIdParking(Long.parseLong(ConstantesTest.ID_PARKING_CARRO));
		parkingCarro.setIdVigilante(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		parkingCarro.setFechaIngreso(new Date(1000));
		parkingCarro.setFechaSalida(new Date(100000));
		parkingCarro.setNumPlaca(ConstantesTest.NUM_PLACA);
		parkingCarro.setCilindrajeVehiculo(ConstantesTest.CILINDRAJE_VEHICULO);
		parkingCarro.setTipoVehiculo(ConstantesTest.TIPO_VEHICULO_CARRO);
		parkingCarro.setPuesto(Integer.parseInt(ConstantesTest.PUESTO));
		parkingCarro.setEstado(ConstantesTest.ESTADO_INGRESO);
		parkingEntityCarro = parkingCarro;
	}
	
	@Before
	public void setupDTO() {
		
		ParkingDTO parkingMotoDTO = new ParkingDTO();
		parkingMotoDTO.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
		parkingMotoDTO.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
		parkingMotoDTO.setFechaIngresoDTO(new Date(1000));
		parkingMotoDTO.setFechaSalidaDTO(new Date(100000));
		parkingMotoDTO.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
		parkingMoto = parkingMotoDTO;
		
		ParkingDTO parkingCarroDTO = new ParkingDTO();
		parkingCarroDTO.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
		parkingCarroDTO.setFechaIngresoDTO(new Date(1000));
		parkingCarroDTO.setFechaSalidaDTO(new Date(100000));
		parkingCarroDTO.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_CARRO);
		parkingCarroDTO.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
		parkingCarro = parkingCarroDTO;
		
	}
	
	
	@Test
	public void saveParkingMoto()  {
		
		when(service.saveOrUpdateParking(Mockito.anyObject())).thenReturn(parkingEntityMoto);
		ParkingDTO parkMoto = bussines.saveParking(parkingMoto);
		Assert.assertTrue(Objects.nonNull(parkMoto));
		
	}
	
	@Test
	public void saveParkingCarro()  {
		
		when(service.saveOrUpdateParking(Mockito.anyObject())).thenReturn(parkingEntityCarro);
		ParkingDTO parkCarro = bussines.saveParking(parkingCarro);
		Assert.assertTrue(Objects.nonNull(parkCarro));
		
	}
	
	@Test
	public void saveSalidaMoto()  {
		
		when(service.saveOrUpdateParking(Mockito.anyObject())).thenReturn(parkingEntityMoto);
		ParkingDTO salidaMoto = bussines.salidaVehiculo(parkingMoto);
		Assert.assertTrue(Objects.nonNull(salidaMoto));
		
	}
	
	@Test
	public void saveSalidaCarro()  {
		
		when(service.saveOrUpdateParking(Mockito.anyObject())).thenReturn(parkingEntityCarro);
		ParkingDTO salidaCarro = bussines.salidaVehiculo(parkingCarro);
		Assert.assertTrue(Objects.nonNull(salidaCarro));
		
	}
	
}
