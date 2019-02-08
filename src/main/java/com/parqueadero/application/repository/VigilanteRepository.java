package com.parqueadero.application.repository;



import org.springframework.data.repository.CrudRepository;

import com.parqueadero.application.entity.Vigilante;



public interface VigilanteRepository extends CrudRepository<Vigilante, Long> {

    
}
