package com.parqueadero.application.bussines;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.dto.RespuestaParkingDTO;
import com.parqueadero.application.entity.Parking;
import com.parqueadero.application.service.ParkingService;
import com.parqueadero.application.utils.ConstanteEnun;
import com.parqueadero.application.utils.Constantes;

@Service
@Transactional
public class ParkingBussines {

	@Autowired
	ParkingService servicioPa;

	public String ping() {
		return Constantes.MENSAJE_PING;
	}

	public List<Parking> getAllParking() {
		return servicioPa.getAllParking();
	}

	public Parking getParkingId(Long id) {
		return servicioPa.getParkingById(id);
	}

	public void deleteParking(Long id) {
		servicioPa.deleteParking(id);

	}

	 int countCarro = 0;
	 int countMoto = 0;
	 double saldo = 0.0;
	 double saldoCarro = 0.0;
	 double saldoMoto = 0.0;

	public ParkingDTO saveParking(ParkingDTO registro) {

		ParkingDTO answer = null;

		if (!validarPlaca(registro.getNumPlacaDTO())) {

			RespuestaParkingDTO respuestaParking = new RespuestaParkingDTO();
			respuestaParking.setMensaje(Constantes.MENSAJE_PLACA);

		} else {

			answer = this.validarPuestoVehiculo(registro);

		}

		return answer;

	}

	public ParkingDTO validarPuestoVehiculo(ParkingDTO registro) {

		
		Parking anser = null;
		ParkingDTO respuesta = null;
		
		if (registro.getTipoVehiculoDTO().equals(Constantes.TIPO_CARRO)) {

			if (countCarro <= 20) {

				countCarro++;
				anser = this.guardarParking(registro);
				respuesta = this.convertirEntityToDTO(anser);

			} else {
				
				RespuestaParkingDTO respuestaParking = new RespuestaParkingDTO();
				respuestaParking.setMensaje(Constantes.SUPERO_CANTIDAD_CARRO);

			}

		} else if (registro.getTipoVehiculoDTO().equals(Constantes.TIPO_MOTO)) {

			if (countMoto <= 10) {

				countMoto++;
				anser = this.guardarParking(registro);
				respuesta = this.convertirEntityToDTO(anser);

			} else {

				RespuestaParkingDTO respuestaParking = new RespuestaParkingDTO();
				respuestaParking.setMensaje(Constantes.SUPERO_CANTIDAD_MOTO);
			}

		}

		return respuesta;
	}

	public Parking guardarParking(ParkingDTO parking) {

		Parking entityParking = new Parking();
		entityParking.setIdParking(parking.getIdParkingDTO());
		entityParking.setIdVigilante(parking.getIdVigilanteDTO());
		entityParking.setFechaIngreso(new Date());
		entityParking.setNumPlaca(parking.getNumPlacaDTO());
		entityParking.setCilindrajeVehiculo(parking.getCilindrajeVehiculoDTO());
		entityParking.setTipoVehiculo(parking.getTipoVehiculoDTO());
		entityParking.setEstado(Constantes.INGRESO);

		if (parking.getTipoVehiculoDTO().equals(Constantes.TIPO_CARRO)) {

			entityParking.setPuesto(countCarro);

		} else if (parking.getTipoVehiculoDTO().equals(Constantes.TIPO_MOTO)) {

			entityParking.setPuesto(countMoto);

		}

		return servicioPa.saveOrUpdateParking(entityParking);

		 
	}

	public boolean validarPlaca(String placa) {

		String letraPlaca = "";
		letraPlaca = placa.substring(0, 1);
		String diaSemana = "";
		boolean flagPlaca;
		
		
		if (letraPlaca.equals(Constantes.LETRA_A_MAYUS) || letraPlaca.equals(Constantes.LETRA_A_MINUS)) {

			diaSemana = this.obtenerDia();

			if (diaSemana.equals(ConstanteEnun.LUNES.toString())
					|| diaSemana.equals(ConstanteEnun.DOMINGO.toString())) {
				flagPlaca = false;
				
			} else {
				
				flagPlaca = true;
				
			}

		} else {

			flagPlaca = true;

		}

		return flagPlaca;

	}

	public String obtenerDia() {

		int dia = 0;
		Calendar c = Calendar.getInstance();
		Date fechaActual = new Date();
		c.setTime(fechaActual);
		String diaSemana = "";
		
		
		dia = c.get(Calendar.DAY_OF_WEEK);

		switch (dia) {
		case 1:
			diaSemana = ConstanteEnun.DOMINGO.toString();
			break;
		case 2:
			diaSemana = ConstanteEnun.LUNES.toString();
			break;
		case 3:
			diaSemana = ConstanteEnun.MARTES.toString();
			break;
		case 4:
			diaSemana = ConstanteEnun.MIERCOLES.toString();
			break;
		case 5:
			diaSemana = ConstanteEnun.JUEVES.toString();
			break;
		case 6:
			diaSemana = ConstanteEnun.VIERNES.toString();
			break;
		case 7:
			diaSemana = ConstanteEnun.SABADO.toString();
			break;
		default:
			diaSemana = ConstanteEnun.DOMINGO.toString();
			break;
		}

		return diaSemana;
	}

	public ParkingDTO convertirEntityToDTO(Parking parking) {
		
		ParkingDTO convertDTO = new ParkingDTO();
		convertDTO.setIdParkingDTO(parking.getIdParking());
		convertDTO.setFechaIngresoDTO(parking.getFechaIngreso());
		convertDTO.setFechaSalidaDTO(parking.getFechaSalida());
		convertDTO.setIdVigilanteDTO(parking.getIdVigilante());
		convertDTO.setNumPlacaDTO(parking.getNumPlaca());
		convertDTO.setPuestoDTO(parking.getPuesto());
		convertDTO.setTarifaDTO(parking.getTarifa());
		convertDTO.setTipoVehiculoDTO(parking.getTipoVehiculo());
		convertDTO.setCilindrajeVehiculoDTO(parking.getCilindrajeVehiculo());
		convertDTO.setEstadoDTO(parking.getEstado());

		return convertDTO;

	}

	public ParkingDTO salidaVehiculo(ParkingDTO registro) {

		Parking respuesta =  guardarSalidaVehiculo(registro);

		return  this.convertirEntityToDTO(respuesta);
		
	}

	public double validarFechaSalidaCarro(LocalDateTime fechaSalida, LocalDateTime fechaEntrada) {
		long horas = ChronoUnit.HOURS.between(fechaSalida, fechaEntrada);
		if (horas <= 0) {
			horas = ChronoUnit.SECONDS.between(fechaEntrada, fechaSalida) > 0 ? 
					1: 0;
		}
		if (horas > 0 && horas <= 9) {
			long calculoHoras = 1000L * horas;
			saldo = saldo + calculoHoras;
			return saldo;
		}
		if (ChronoUnit.HOURS.between(fechaSalida, fechaEntrada) > 9) {
			fechaSalida = fechaSalida.plusHours(24);
			saldo += 8000;
			return validarFechaSalidaCarro(fechaSalida, fechaEntrada);
		}
		return saldo;
	}

	public double validarFechaSalidaMoto(LocalDateTime fechaSalida, LocalDateTime fechaIngreso) {
		long horas = ChronoUnit.HOURS.between(fechaSalida, fechaIngreso);
		if (horas <= 0) {
			horas = ChronoUnit.SECONDS.between(fechaIngreso, fechaSalida) > 0 ? 
					1: 0;
		}
		if (horas > 0 && horas <= 9) {
			long calculoHoras = 500L * horas;
			saldo = saldo + calculoHoras;
			return saldo;
		}
		if (ChronoUnit.HOURS.between(fechaSalida, fechaIngreso) > 9) {
			fechaSalida = fechaSalida.plusHours(24);
			saldo += 4000;
			return validarFechaSalidaMoto(fechaSalida, fechaIngreso);
		}
		return saldo;
	}

	public Parking guardarSalidaVehiculo(ParkingDTO parking) {
		
		Parking entityParking = new Parking();
		entityParking.setIdParking(parking.getIdParkingDTO());
		entityParking.setIdVigilante(parking.getIdVigilanteDTO());
		entityParking.setTarifa(parking.getTarifaDTO());
		entityParking.setFechaIngreso(parking.getFechaIngresoDTO());
		entityParking.setFechaSalida(new Date());
		entityParking.setNumPlaca(parking.getNumPlacaDTO());
		entityParking.setCilindrajeVehiculo(parking.getCilindrajeVehiculoDTO());
		entityParking.setTipoVehiculo(parking.getTipoVehiculoDTO());
		entityParking.setEstado("SALIDA");

		if (parking.getTipoVehiculoDTO().equals(Constantes.TIPO_CARRO)) {
			countCarro --;
			entityParking.setPuesto(countCarro);
		    saldoCarro = this.validarFechaSalidaCarro(entityParking.getFechaSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),parking.getFechaIngresoDTO().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		    entityParking.setTarifa(saldoCarro);
		    
		} else if (parking.getTipoVehiculoDTO().equals(Constantes.TIPO_MOTO)) {
			countMoto --;
			entityParking.setPuesto(countMoto);
			saldoMoto = this.validarFechaSalidaMoto(entityParking.getFechaSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),parking.getFechaIngresoDTO().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			entityParking.setTarifa(saldoMoto);
		}

		return servicioPa.saveOrUpdateParking(entityParking);

	}
	
	
	
	public Parking saveVigilante(Parking parking) {
		
		return servicioPa.saveOrUpdateParking(parking);
		
	}

}
