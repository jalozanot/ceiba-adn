package com.parqueadero.application.bussines;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.application.constantes.ConstantesVal;
import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.entity.Parking;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingBussinesTest {
	
	@Autowired
	ParkingBussines parkingBussines;
	
	
	@Test
	public void guardarRegistroParking() {
		ParkingDTO parqueo = new ParkingDTO();
		parqueo.setNumPlacaDTO(ConstantesVal.NUM_PLACA);
		parqueo.setCilindrajeVehiculoDTO(ConstantesVal.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculoDTO(ConstantesVal.TIPO_VEHICULO_MOTO);
		
		ParkingDTO answer = parkingBussines.saveParking(parqueo);
		
		Assert.assertTrue(Objects.nonNull(answer));
		
	}
	
	@Test
	public void obtenerAllParking() {
		
		List<Parking> listParking = parkingBussines.getAllParking();
		Assert.assertTrue(Objects.nonNull(listParking));
	}
	
	@Test
	public void obtenerByIdParking() {
		
		Parking respuesta = parkingBussines.getParkingId(Long.parseLong(ConstantesVal.ID_PARKING));
		Assert.assertTrue(Objects.nonNull(respuesta));
	
	}
	
	@Test
	public void validarPuestoVehiculoMoto() {
		
		ParkingDTO parqueo = new ParkingDTO();
		parqueo.setIdParkingDTO(Long.parseLong(ConstantesVal.ID_PARKING));
		parqueo.setNumPlacaDTO(ConstantesVal.NUM_PLACA);
		parqueo.setIdVigilanteDTO(Long.parseLong(ConstantesVal.ID_VIGILANTE));
		parqueo.setCilindrajeVehiculoDTO(ConstantesVal.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculoDTO(ConstantesVal.TIPO_VEHICULO_MOTO);
		parqueo.setPuestoDTO(Integer.parseInt(ConstantesVal.PUESTO));
		parqueo.setEstadoDTO(ConstantesVal.ESTADO_SALIDA);
		
		ParkingDTO puesto = parkingBussines.validarPuestoVehiculo(parqueo);
	    Assert.assertTrue(Objects.nonNull(puesto));
		
	}
	

	

	@Test
	public void convertirDTO() {
		
		Parking parqueo = new Parking();
		parqueo.setIdParking(Long.parseLong(ConstantesVal.ID_PARKING));
		parqueo.setNumPlaca(ConstantesVal.NUM_PLACA);
		parqueo.setIdVigilante(Long.parseLong(ConstantesVal.ID_VIGILANTE));
		parqueo.setCilindrajeVehiculo(ConstantesVal.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculo(ConstantesVal.TIPO_VEHICULO_MOTO);
		parqueo.setPuesto(Integer.parseInt(ConstantesVal.PUESTO));
		parqueo.setEstado(ConstantesVal.ESTADO_SALIDA);
		
		ParkingDTO convert = parkingBussines.convertirEntityToDTO(parqueo);
		
		Assert.assertTrue(convert.getIdParkingDTO().equals(parqueo.getIdParking()));
		
	}
	
	

	
	
	@Test
	public void validarPing() {
		
		Assert.assertTrue(Objects.nonNull(parkingBussines.ping()));
	}
	

	
	
	
	@Test
	public void guardarParking() {
		
		ParkingDTO parqueo = new ParkingDTO();
		parqueo.setIdParkingDTO(Long.parseLong(ConstantesVal.ID_PARKING));
		parqueo.setNumPlacaDTO(ConstantesVal.NUM_PLACA);
		parqueo.setIdVigilanteDTO(Long.parseLong(ConstantesVal.ID_VIGILANTE));
		parqueo.setCilindrajeVehiculoDTO(ConstantesVal.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculoDTO(ConstantesVal.TIPO_VEHICULO_MOTO);
		parqueo.setPuestoDTO(Integer.parseInt(ConstantesVal.PUESTO));
		parqueo.setEstadoDTO(ConstantesVal.ESTADO_SALIDA);
		
		Parking parkingEntity = parkingBussines.guardarParking(parqueo);
		
		Assert.assertTrue(Objects.nonNull(parkingEntity));
		
	}
	

	
	@Test
	public void validarPlaca() {
		
		boolean flag = parkingBussines.validarPlaca(ConstantesVal.NUM_PLACA);
		Assert.assertTrue(flag);
		
	}
	
	
	@Test
	public void validarPlacaIniA() {
		
		boolean flag = parkingBussines.validarPlaca(ConstantesVal.NUM_PLACA_A);
		Assert.assertTrue(flag);
		
	}
	

//	@Test
//	public void salidaVehiculo() {
//		
//		ParkingDTO parqueo = new ParkingDTO();
//		parqueo.setIdParkingDTO(Long.parseLong(ConstantesVal.ID_PARKING));
//		parqueo.setNumPlacaDTO(ConstantesVal.NUM_PLACA);
//		parqueo.setIdVigilanteDTO(Long.parseLong(ConstantesVal.ID_VIGILANTE));
//		parqueo.setFechaIngresoDTO(new Date(10000));
//		parqueo.setFechaSalidaDTO(new Date(2000000));
//		parqueo.setCilindrajeVehiculoDTO(ConstantesVal.CILINDRAJE_VEHICULO);
//		parqueo.setTipoVehiculoDTO(ConstantesVal.TIPO_VEHICULO_MOTO);
//		parqueo.setPuestoDTO(Integer.parseInt(ConstantesVal.PUESTO));
//		parqueo.setEstadoDTO(ConstantesVal.ESTADO_SALIDA);
//		
//		Parking respuesta = parkingBussines.guardarSalidaVehiculo(parqueo);
//		
//		Assert.assertTrue(Objects.nonNull(respuesta));
//		
//	}
	
	@Test
	public void diaSemana() {
		Assert.assertTrue(Objects.nonNull(parkingBussines.diaSemana(1)));
	}
	
	
}
