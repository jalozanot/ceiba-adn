package com.parqueadero.application.dto;

public class RespuestaParkingDTO {
	
	private ParkingDTO parking;
	private String mensaje;
	
	public ParkingDTO getParking() {
		return parking;
	}
	public void setParking(ParkingDTO parking) {
		this.parking = parking;
	}
		
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
