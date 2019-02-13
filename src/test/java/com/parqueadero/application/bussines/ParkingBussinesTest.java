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
	
	@Test
	public void obtenerDia() {
		String dia = parkingBussines.obtenerDia();
		Assert.assertTrue(ConstantesTest.MIERCOLES.equals(dia));
	}
	
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
	
}