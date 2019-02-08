package com.parqueadero.application.dto;

import java.util.Date;

import javax.persistence.Column;

public class ParkingDTO {
	
	private Long idParking;
	private Date fechaIngreso;
	private Date fechaSalida;
	private Double tarifa;
	private Long idVigilante;
	private String numPlaca;	
	private String cilindrajeVehiculo;	
	private String tipoVehiculo;
	private int puesto;
	private String estado;
	
	public Long getIdParking() {
		return idParking;
	}
	public void setIdParking(Long idParking) {
		this.idParking = idParking;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Double getTarifa() {
		return tarifa;
	}
	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public Long getIdVigilante() {
		return idVigilante;
	}
	public void setIdVigilante(Long idVigilante) {
		this.idVigilante = idVigilante;
	}
	public String getNumPlaca() {
		return numPlaca;
	}
	public void setNumPlaca(String numPlaca) {
		this.numPlaca = numPlaca;
	}
	public String getCilindrajeVehiculo() {
		return cilindrajeVehiculo;
	}
	public void setCilindrajeVehiculo(String cilindrajeVehiculo) {
		this.cilindrajeVehiculo = cilindrajeVehiculo;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public int getPuesto() {
		return puesto;
	}
	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
