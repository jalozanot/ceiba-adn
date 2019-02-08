package com.parqueadero.application.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parking")
public class Parking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idParking")
	private Long idParking;
	@Column(name="fechaIngreso")
	private Date fechaIngreso;
	@Column(name="fechaSalida")
	private Date fechaSalida;
	@Column(name="tarifa")
	private Double tarifa;
	@Column(name="idVigilante")
	private Long idVigilante;
	@Column(name="numPlaca")
	private String numPlaca;
	@Column(name="cilindrajeVehiculo")
	private String cilindrajeVehiculo;
	@Column(name="tipoVehiculo")
	private String tipoVehiculo;
	@Column(name="puesto")
	private int puesto;
	@Column(name="estado")
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
