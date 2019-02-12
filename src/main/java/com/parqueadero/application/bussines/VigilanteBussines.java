package com.parqueadero.application.bussines;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parqueadero.application.entity.Vigilante;
import com.parqueadero.application.service.VigilanteService;
import com.parqueadero.application.utils.Constantes;

@Service
public class VigilanteBussines {

	@Autowired
	VigilanteService serviceVigilante;

	public String ping() {
		return Constantes.MENSAJE_PING;
	}

	public List<Vigilante> getAllVigilante() {
		return serviceVigilante.getAllVigilante();
	}

	public Vigilante getVigilanteId(Long id) {
		return serviceVigilante.getVigilanteById(id);
	}

	public Vigilante saveVigilante(Vigilante vigilante) {
		return serviceVigilante.saveOrUpdateVigilante(vigilante);
		
	}
	
	public void deleteVigilante(Long id) {
		serviceVigilante.deleteVigilante(id);

	}

}
