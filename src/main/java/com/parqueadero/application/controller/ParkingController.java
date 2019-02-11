package com.parqueadero.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parqueadero.application.bussines.ParkingBussines;
import com.parqueadero.application.dto.ParkingDTO;
import com.parqueadero.application.entity.Parking;

@RestController
@RequestMapping(value = "/parking")
@CrossOrigin 
public class ParkingController {

	@Autowired
	ParkingBussines parkingBussines;

	@GetMapping(value = "/ping")
	public String ping() {
		return parkingBussines.ping();
	}

	@GetMapping("/allVechiculos")
	public List<Parking> getAllVehiculos() {
		return parkingBussines.getAllParking();
	}

	@GetMapping("/parking/{id}")
	public Parking getVehiculoId(@PathVariable("id") Long id) {
		return parkingBussines.getParkingId(id);
	}

	@DeleteMapping("/deleteVehiculo/{id}")
	public void deleteParking(@PathVariable("id") Long id) {
		parkingBussines.deleteParking(id);
		
	}

	@PostMapping("/ingreso")
	public ParkingDTO saveVehiculo(@RequestBody ParkingDTO registro) {
		
		ParkingDTO answerDTO = parkingBussines.saveParking(registro);
		
		return answerDTO;
	}
	
	@PostMapping("/salida")
	public ParkingDTO salidaVehiculo(@RequestBody ParkingDTO registro) {
		
		ParkingDTO answerDTO = parkingBussines.salidaVehiculo(registro);
		
		return answerDTO;
	}

}
