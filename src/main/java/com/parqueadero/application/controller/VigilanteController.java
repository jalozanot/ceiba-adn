package com.parqueadero.application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parqueadero.application.bussines.VigilanteBussines;
import com.parqueadero.application.entity.Vigilante;



@RestController
@RequestMapping(value="/Vigilante")
public class VigilanteController {

    @Autowired
    VigilanteBussines vigilanteBussines;

    @GetMapping("/ping")
    private String ping() {
        return vigilanteBussines.ping();
    }
    
    @GetMapping("/allVigilante")
    private List<Vigilante> getAllVigilante() {
        return vigilanteBussines.getAllVigilante();
    }

    @GetMapping("/Vigilante/{id}")
    private Vigilante getVigilanteId(@PathVariable("id") Long id) {
        return vigilanteBussines.getVigilanteId(id);
    }

    @DeleteMapping("/deleteVigilante/{id}")
    private void deleteVigilante(@PathVariable("id") Long id) {
    	vigilanteBussines.deleteVigilante(id);
    }

    @PostMapping("/save")
    private Long saveVehiculo(@RequestBody Vigilante vigilante) {
    	vigilanteBussines.saveVigilante(vigilante);
        return vigilante.getIdVigilante();
    }
}
