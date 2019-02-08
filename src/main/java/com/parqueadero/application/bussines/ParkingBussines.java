package com.parqueadero.application.bussines;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parqueadero.application.dto.GuardarRegistroDTO;
import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.dto.RespuestaParkingDTO;
import com.parqueadero.application.entity.Parking;
import com.parqueadero.application.service.ParkingService;
import com.parqueadero.application.utils.Constantes;

@Service
public class ParkingBussines {

	@Autowired
	ParkingService servicioPa;

	public String ping() {
		return "retorno de informacion de parking";
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

	 private static int countCarro = 0;
	 static int countMoto = 0;
	 static double saldo = 0.0;

	public ParkingDTO saveParking(GuardarRegistroDTO registro) {

		ParkingDTO answer = null;

		if (!validarPlaca(registro.parking.getNumPlaca())) {

			RespuestaParkingDTO respuestaParking = new RespuestaParkingDTO();
			respuestaParking.setMensaje(Constantes.MENSAJE_PLACA);

		} else {

			answer = this.validarPuestoVehiculo(registro);

		}

		return answer;

	}

	private ParkingDTO validarPuestoVehiculo(GuardarRegistroDTO registro) {

		boolean flagPuesto;
		Parking anser = null;
		ParkingDTO respuesta = null;
		if (registro.parking.getTipoVehiculo().equals(Constantes.TIPO_CARRO)) {

			if (countCarro <= 20) {

				countCarro++;
				anser = this.guardarParking(registro.parking);
				System.out.println("linea numero 74 :::::: " + anser.getIdParking());
				respuesta = this.convertirEntityToDTO(anser);

			} else {
				// TODO
				// mensaje parking full
				System.out.println("linea numero 96 :::::: NO PUEDE INGRESAR " + countCarro);

			}

		} else if (registro.parking.getTipoVehiculo().equals(Constantes.TIPO_MOTO)) {

			if (countMoto <= 10) {

				countMoto++;
				anser = this.guardarParking(registro.parking);
				System.out.println("linea numero 89 :::::: " + anser.getIdParking());
				respuesta = this.convertirEntityToDTO(anser);

			} else {

				// TODO
				// mensaje parking full
				System.out.println("linea numero 96 :::::: NO PUEDE INGRESAR " + countMoto);
			}

		}

		return respuesta;
	}

	private Parking guardarParking(ParkingDTO parking) {

		Parking entityParking = new Parking();
		entityParking.setIdParking(parking.getIdParking());
		entityParking.setIdVigilante(parking.getIdVigilante());
		//entityParking.setTarifa(parking.getTarifa());
		entityParking.setFechaIngreso(new Date());
		entityParking.setNumPlaca(parking.getNumPlaca());
		entityParking.setCilindrajeVehiculo(parking.getCilindrajeVehiculo());
		entityParking.setTipoVehiculo(parking.getTipoVehiculo());
		entityParking.setEstado("INGRESO");

		if (parking.getTipoVehiculo().equals(Constantes.TIPO_CARRO)) {

			entityParking.setPuesto(countCarro);

		} else if (parking.getTipoVehiculo().equals(Constantes.TIPO_MOTO)) {

			entityParking.setPuesto(countMoto);

		}

		Parking park = servicioPa.saveOrUpdateParking(entityParking);

		System.out.println("linea numero 126 :::::: " + park.getIdParking());

		return park;
	}

	private boolean validarPlaca(String placa) {

		Date d = new Date();
		String letraPlaca = "";
		letraPlaca = placa.substring(0, 1);
		String diaSemana = "";
		boolean flagPlaca;

		if (letraPlaca.equals("A") || letraPlaca.equals("a")) {

			diaSemana = this.obtenerDia();

			if (diaSemana.equals(Constantes.diasSemana.LUNES.toString())
					|| diaSemana.equals(Constantes.diasSemana.DOMINGO.toString())) {
				flagPlaca = false;
				
			} else {
				
				flagPlaca = true;
				
			}

		} else {

			flagPlaca = true;

		}

		return flagPlaca;

	}

	private String obtenerDia() {

		int dia = 0;
		Calendar c = Calendar.getInstance();
		Date fechaActual = new Date();
		c.setTime(fechaActual);
		String diaSemana = "";

		dia = c.get(Calendar.DAY_OF_WEEK);

		switch (dia) {
		case 1:
			diaSemana = Constantes.diasSemana.DOMINGO.toString();
			break;
		case 2:
			diaSemana = Constantes.diasSemana.LUNES.toString();
			break;
		case 3:
			diaSemana = Constantes.diasSemana.MARTES.toString();
			break;
		case 4:
			diaSemana = Constantes.diasSemana.MIERCOLES.toString();
			break;
		case 5:
			diaSemana = Constantes.diasSemana.JUEVES.toString();
			break;
		case 6:
			diaSemana = Constantes.diasSemana.VIERNES.toString();
			break;
		case 7:
			diaSemana = Constantes.diasSemana.SABADO.toString();
			break;
		default:
			diaSemana = Constantes.diasSemana.DOMINGO.toString();
			break;
		}

		return diaSemana;
	}

	private ParkingDTO convertirEntityToDTO(Parking parking) {

		ParkingDTO convertDTO = new ParkingDTO();
		convertDTO.setIdParking(parking.getIdParking());
		convertDTO.setFechaIngreso(parking.getFechaIngreso());
		convertDTO.setFechaSalida(parking.getFechaSalida());
		convertDTO.setIdVigilante(parking.getIdVigilante());
		convertDTO.setNumPlaca(parking.getNumPlaca());
		convertDTO.setPuesto(parking.getPuesto());
		convertDTO.setTarifa(parking.getTarifa());
		convertDTO.setTipoVehiculo(parking.getTipoVehiculo());
		convertDTO.setCilindrajeVehiculo(parking.getCilindrajeVehiculo());
		convertDTO.setEstado(parking.getEstado());

		return convertDTO;

	}

	public ParkingDTO salidaVehiculo(GuardarRegistroDTO registro) {

		Parking respuesta =  guardarSalidaVehiculo(registro.parking);

		ParkingDTO tarifa = this.convertirEntityToDTO(respuesta);
		
		return tarifa;
	}

	public static double validarFechaSalidaCarro(LocalDateTime fechaSalida, LocalDateTime fechaEntrada) {
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

	public static double validarFechaSalidaMoto(LocalDateTime fechaSalida, LocalDateTime fechaIngreso) {
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

	private Parking guardarSalidaVehiculo(ParkingDTO parking) {

		Parking entityParking = new Parking();
		entityParking.setIdParking(parking.getIdParking());
		entityParking.setIdVigilante(parking.getIdVigilante());
		entityParking.setTarifa(parking.getTarifa());
		entityParking.setFechaIngreso(parking.getFechaIngreso());
		entityParking.setFechaSalida(new Date());
		entityParking.setNumPlaca(parking.getNumPlaca());
		entityParking.setCilindrajeVehiculo(parking.getCilindrajeVehiculo());
		entityParking.setTipoVehiculo(parking.getTipoVehiculo());
		entityParking.setEstado("SALIDA");

		if (parking.getTipoVehiculo().equals(Constantes.TIPO_CARRO)) {
			countCarro --;
			entityParking.setPuesto(countCarro);
			double saldo = this.validarFechaSalidaCarro(entityParking.getFechaSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),parking.getFechaIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		} else if (parking.getTipoVehiculo().equals(Constantes.TIPO_MOTO)) {
			countMoto --;
			entityParking.setPuesto(countMoto);
			double saldo = this.validarFechaSalidaMoto(entityParking.getFechaSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),parking.getFechaIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			entityParking.setTarifa(saldo);
			System.out.println("linea numero 284 :::::: " + saldo);
		}

		Parking park = servicioPa.saveOrUpdateParking(entityParking);

		return park;
	}

}
