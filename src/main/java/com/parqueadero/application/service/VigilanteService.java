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
        
        return (List<Vigilante>)vigilanteRepository.findAll();
    
    }

    public Vigilante getVigilanteById(Long id) {
        return vigilanteRepository.findById(id).get();
    }

    public void saveOrUpdateVigilante(Vigilante vigilante) {
    	vigilanteRepository.save(vigilante);
    }

    public void deleteVigilante(Long id) {
    	vigilanteRepository.deleteById(id);
    }
    
}