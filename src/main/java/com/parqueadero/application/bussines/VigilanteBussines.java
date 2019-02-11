package com.parqueadero.application.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parqueadero.application.entity.Vigilante;
import com.parqueadero.application.service.VigilanteService;

@Service
public class VigilanteBussines {

	@Autowired
	VigilanteService serviceVigilante;

	public String ping() {
		return "ping para vehiculoController";
	}

	public List<Vigilante> getAllVigilante() {
		return serviceVigilante.getAllVigilante();
	}

	public Vigilante getVigilanteId(Long id) {
		return serviceVigilante.getVigilanteById(id);
	}

	public Long saveVigilante(Vigilante vigilante) {
		serviceVigilante.saveOrUpdateVigilante(vigilante);
		return vigilante.getIdVigilante();
	}
	
	public void deleteVigilante(Long id) {
		serviceVigilante.deleteVigilante(id);

	}

}
