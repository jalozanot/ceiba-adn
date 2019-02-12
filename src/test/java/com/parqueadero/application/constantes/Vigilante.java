package com.parqueadero.application.constantes;

public class Vigilante {
	

	private String idVigilante;
	private String nombre;
	private String apellido;
	private String cedula;
	
	public Vigilante() {
		super();
	}
	
	public String getIdVigilante() {
		return idVigilante;
	}
	public void setIdVigilante(String idVigilante) {
		this.idVigilante = idVigilante;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
}
