package com.parqueadero.application.dto;

import java.util.Date;


public class ParkingDTO {
	
	private Long idParkingDTO;
	private Date fechaIngresoDTO;
	private Date fechaSalidaDTO;
	private Double tarifaDTO;
	private Long idVigilanteDTO;
	private String numPlacaDTO;	
	private String cilindrajeVehiculoDTO;	
	private String tipoVehiculoDTO;
	private int puestoDTO;
	private String estadoDTO;
	
	public Long getIdParkingDTO() {
		return idParkingDTO;
	}
	public void setIdParkingDTO(Long idParkingDTO) {
		this.idParkingDTO = idParkingDTO;
	}
	public Date getFechaIngresoDTO() {
		return fechaIngresoDTO;
	}
	public void setFechaIngresoDTO(Date fechaIngresoDTO) {
		this.fechaIngresoDTO = fechaIngresoDTO;
	}
	public Date getFechaSalidaDTO() {
		return fechaSalidaDTO;
	}
	public void setFechaSalidaDTO(Date fechaSalidaDTO) {
		this.fechaSalidaDTO = fechaSalidaDTO;
	}
	public Double getTarifaDTO() {
		return tarifaDTO;
	}
	public void setTarifaDTO(Double tarifaDTO) {
		this.tarifaDTO = tarifaDTO;
	}
	public Long getIdVigilanteDTO() {
		return idVigilanteDTO;
	}
	public void setIdVigilanteDTO(Long idVigilanteDTO) {
		this.idVigilanteDTO = idVigilanteDTO;
	}
	public String getNumPlacaDTO() {
		return numPlacaDTO;
	}
	public void setNumPlacaDTO(String numPlacaDTO) {
		this.numPlacaDTO = numPlacaDTO;
	}
	public String getCilindrajeVehiculoDTO() {
		return cilindrajeVehiculoDTO;
	}
	public void setCilindrajeVehiculoDTO(String cilindrajeVehiculoDTO) {
		this.cilindrajeVehiculoDTO = cilindrajeVehiculoDTO;
	}
	public String getTipoVehiculoDTO() {
		return tipoVehiculoDTO;
	}
	public void setTipoVehiculoDTO(String tipoVehiculoDTO) {
		this.tipoVehiculoDTO = tipoVehiculoDTO;
	}
	public int getPuestoDTO() {
		return puestoDTO;
	}
	public void setPuestoDTO(int puestoDTO) {
		this.puestoDTO = puestoDTO;
	}
	public String getEstadoDTO() {
		return estadoDTO;
	}
	public void setEstadoDTO(String estadoDTO) {
		this.estadoDTO = estadoDTO;
	}
	
	
	
	
	
}
