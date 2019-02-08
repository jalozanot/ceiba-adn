package com.parqueadero.application.repository;





import org.springframework.data.repository.CrudRepository;

import com.parqueadero.application.entity.Parking;



public interface ParkingRepository extends CrudRepository<Parking, Long> {

}
