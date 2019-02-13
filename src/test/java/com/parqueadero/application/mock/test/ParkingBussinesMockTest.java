package com.parqueadero.application.mock.test;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.application.bussines.ParkingBussines;
import com.parqueadero.application.constantes.ConstantesTest;
import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.entity.Parking;
import com.parqueadero.application.service.ParkingService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingBussinesMockTest {
	
	@MockBean
	private ParkingService service;
	
	@Autowired
	private ParkingBussines bussines;
	
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
		
//		Parking parkingCarro = new Parking();
//		parkingCarro.setIdParking(Long.parseLong(ConstantesTest.ID_PARKING_CARRO));
//		parkingCarro.setIdVigilante(Long.parseLong(ConstantesTest.ID_VIGILANTE));
//		parkingCarro.setNumPlaca(ConstantesTest.NUM_PLACA);
//		parkingCarro.setCilindrajeVehiculo(ConstantesTest.CILINDRAJE_VEHICULO);
//		parkingCarro.setTipoVehiculo(ConstantesTest.TIPO_VEHICULO_CARRO);
//		parkingCarro.setPuesto(Integer.parseInt(ConstantesTest.PUESTO));
//		parkingCarro.setEstado(ConstantesTest.ESTADO_INGRESO);
//		parkingEntityCarro = parkingCarro;
	}
	
//	@Before
//	public void setupDTO() {
//		
//		ParkingDTO parkingMotoDTO = new ParkingDTO();
//		parkingMotoDTO.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
//		parkingMotoDTO.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
//		parkingMotoDTO.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
//		parkingMoto = parkingMotoDTO;
//		
//		ParkingDTO parkingCarroDTO = new ParkingDTO();
//		parkingCarroDTO.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
//		parkingCarroDTO.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_CARRO);
//		parkingCarroDTO.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
//		parkingCarro = parkingMotoDTO;
//		
//	}
	
	
//	@Test
//	public void saveParkingMoto()  {
//		
//		ParkingDTO parkingMotoDTO = new ParkingDTO();
//		parkingMotoDTO.setIdParkingDTO(Long.parseLong("5"));
//		parkingMotoDTO.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
//		parkingMotoDTO.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
//		parkingMotoDTO.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
//		
//		when(service.saveOrUpdateParking(parkingEntityMoto)).thenReturn(parkingEntityMoto);
//		Parking parkMoto = bussines.guardarParking(parkingMotoDTO);
//		Assert.assertTrue("5".equals("5"));
//		
//	}
	
//	@Test
//	public void saveParkingCarro()  {
//		
//		when(service.saveOrUpdateParking(parkingEntityCarro)).thenReturn(parkingEntityCarro);
//		ParkingDTO parkCarro = bussines.saveParking(parkingCarro);
//		Assert.assertTrue(parkCarro.getIdParkingDTO().toString().equals(ConstantesTest.ID_PARKING_CARRO));
//		
//	}
	
}
