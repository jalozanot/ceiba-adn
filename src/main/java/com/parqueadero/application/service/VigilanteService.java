package com.parqueadero.application.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parqueadero.application.entity.Vigilante;
import com.parqueadero.application.repository.VigilanteRepository;


@Service
public class VigilanteService {

    @Autowired
    VigilanteRepository vigilanteRepository;

    public List<Vigilante> getAllVigilante() {
        List<Vigilante> vigilantes = new ArrayList<>();
        vigilanteRepository.findAll().forEach(vigil -> vigilantes.add(vigil));
        return vigilantes;
    }

    public Vigilante getVigilanteById(Long id) {
        return vigilanteRepository.findById(id).get();
    }

    public void saveOrUpdateVigilante(Vigilante vigilante) {
    	vigilanteRepository.save(vigilante);
    }

    public void deleteVigilante(long id) {
    	vigilanteRepository.deleteById(id);
    }
    
}