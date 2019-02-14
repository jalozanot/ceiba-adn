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

import com.parqueadero.application.constantes.ConstantesTest;
import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.entity.Parking;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingBussinesTest {
	
	@Autowired
	ParkingBussines parkingBussines;

	
//	@Test
//	public void obtenerDiaMartes() {
//		String dia = parkingBussines.obtenerDia();
//		if(ConstantesTest.MARTES.equals(dia) ) {
//			Assert.assertTrue(ConstantesTest.MARTES.equals(dia));
//		} else {
//			Assert.assertFalse(ConstantesTest.MARTES.equals(dia));
//		}		
//	}
	
	
	@Test
	public void guardarRegistroParking() {
		ParkingDTO parqueo = new ParkingDTO();
		parqueo.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
		parqueo.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
		
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
		
		Parking respuesta = parkingBussines.getParkingId(Long.parseLong(ConstantesTest.ID_PARKING));
		Assert.assertTrue(Objects.nonNull(respuesta));
	
	}
	
	@Test
	public void validarPuestoVehiculoMoto() {
		
		ParkingDTO parqueo = new ParkingDTO();
		parqueo.setIdParkingDTO(Long.parseLong(ConstantesTest.ID_PARKING));
		parqueo.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
		parqueo.setIdVigilanteDTO(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		parqueo.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
		parqueo.setPuestoDTO(Integer.parseInt(ConstantesTest.PUESTO));
		parqueo.setEstadoDTO(ConstantesTest.ESTADO_SALIDA);
		
		ParkingDTO puesto = parkingBussines.validarPuestoVehiculo(parqueo);
	    Assert.assertTrue(Objects.nonNull(puesto));
		
	}
	
//	@Test
//	public void obtenerDiaLunes() {
//		String dia = parkingBussines.obtenerDia();
//		if(ConstantesTest.LUNES.equals(dia) ) {
//			Assert.assertTrue(ConstantesTest.LUNES.equals(dia));
//		} else {
//			Assert.assertFalse(ConstantesTest.LUNES.equals(dia));
//		}		
//	}
	

	@Test
	public void convertirDTO() {
		
		Parking parqueo = new Parking();
		parqueo.setIdParking(Long.parseLong(ConstantesTest.ID_PARKING));
		parqueo.setNumPlaca(ConstantesTest.NUM_PLACA);
		parqueo.setIdVigilante(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		parqueo.setCilindrajeVehiculo(ConstantesTest.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculo(ConstantesTest.TIPO_VEHICULO_MOTO);
		parqueo.setPuesto(Integer.parseInt(ConstantesTest.PUESTO));
		parqueo.setEstado(ConstantesTest.ESTADO_SALIDA);
		
		ParkingDTO convert = parkingBussines.convertirEntityToDTO(parqueo);
		
		Assert.assertTrue(convert.getIdParkingDTO().equals(parqueo.getIdParking()));
		
	}
	
	
//	@Test
//	public void obtenerDiaMiercoles() {
//		String dia = parkingBussines.obtenerDia();
//		if(ConstantesTest.MIERCOLES.equals(dia) ) {
//			Assert.assertTrue(ConstantesTest.MIERCOLES.equals(dia));
//		} else {
//			Assert.assertFalse(ConstantesTest.MIERCOLES.equals(dia));
//		}		
//	}
	
	
	@Test
	public void validarPing() {
		
		Assert.assertTrue(Objects.nonNull(parkingBussines.ping()));
	}
	
//	@Test
//	public void obtenerDiaDomingo() {
//		String dia = parkingBussines.obtenerDia();
//		if(ConstantesTest.DOMINGO.equals(dia) ) {
//			Assert.assertTrue(ConstantesTest.DOMINGO.equals(dia));
//		} else {
//			Assert.assertFalse(ConstantesTest.DOMINGO.equals(dia));
//		}		
//	}
	
	
	
	@Test
	public void guardarParking() {
		
		ParkingDTO parqueo = new ParkingDTO();
		parqueo.setIdParkingDTO(Long.parseLong(ConstantesTest.ID_PARKING));
		parqueo.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
		parqueo.setIdVigilanteDTO(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		parqueo.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
		parqueo.setPuestoDTO(Integer.parseInt(ConstantesTest.PUESTO));
		parqueo.setEstadoDTO(ConstantesTest.ESTADO_SALIDA);
		
		Parking parkingEntity = parkingBussines.guardarParking(parqueo);
		
		Assert.assertTrue(Objects.nonNull(parkingEntity));
		
	}
	

//	@Test
//	public void obtenerDiaJueves() {
//		String dia = parkingBussines.obtenerDia();
//		if(ConstantesTest.JUEVES.equals(dia) ) {
//			Assert.assertTrue(ConstantesTest.JUEVES.equals(dia));
//		} else {
//			Assert.assertFalse(ConstantesTest.JUEVES.equals(dia));
//		}		
//	}
	
	@Test
	public void validarPlaca() {
		
		boolean flag = parkingBussines.validarPlaca(ConstantesTest.NUM_PLACA);
		Assert.assertTrue(flag);
		
	}
	
	
//	@Test
//	public void obtenerDiaViernes() {
//		String dia = parkingBussines.obtenerDia();
//		if(ConstantesTest.VIERNES.equals(dia) ) {
//			Assert.assertTrue(ConstantesTest.VIERNES.equals(dia));
//		} else {
//			Assert.assertFalse(ConstantesTest.VIERNES.equals(dia));
//		}		
//	}
	
	
	@Test
	public void validarPlacaIniA() {
		
		boolean flag = parkingBussines.validarPlaca(ConstantesTest.NUM_PLACA_A);
		Assert.assertTrue(flag);
		
	}
	
	
	
	
	
	@Test
	public void salidaVehiculo() {
		
		ParkingDTO parqueo = new ParkingDTO();
		parqueo.setIdParkingDTO(Long.parseLong(ConstantesTest.ID_PARKING));
		parqueo.setNumPlacaDTO(ConstantesTest.NUM_PLACA);
		parqueo.setIdVigilanteDTO(Long.parseLong(ConstantesTest.ID_VIGILANTE));
		parqueo.setFechaIngresoDTO(new Date(10000));
		parqueo.setFechaSalidaDTO(new Date(2000000));
		parqueo.setCilindrajeVehiculoDTO(ConstantesTest.CILINDRAJE_VEHICULO);
		parqueo.setTipoVehiculoDTO(ConstantesTest.TIPO_VEHICULO_MOTO);
		parqueo.setPuestoDTO(Integer.parseInt(ConstantesTest.PUESTO));
		parqueo.setEstadoDTO(ConstantesTest.ESTADO_SALIDA);
		
		Parking respuesta = parkingBussines.guardarSalidaVehiculo(parqueo);
		
		Assert.assertTrue(Objects.nonNull(respuesta));
		
	}
	
//	@Test
//	public void obtenerDiaSabado() {
//		String dia = parkingBussines.obtenerDia();
//		if(ConstantesTest.SABADO.equals(dia) ) {
//			Assert.assertTrue(ConstantesTest.SABADO.equals(dia));
//		} else {
//			Assert.assertFalse(ConstantesTest.SABADO.equals(dia));
//		}		
//	}
	
	
}
