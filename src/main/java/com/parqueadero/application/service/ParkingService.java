package com.parqueadero.application.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parqueadero.application.entity.Parking;
import com.parqueadero.application.repository.ParkingRepository;


@Service
public class ParkingService {

    @Autowired
    ParkingRepository parkingRepository;

    public List<Parking> getAllParking() {
        List<Parking> parks = new ArrayList<Parking>();
        parkingRepository.findAll().forEach(parking -> parks.add(parking));
        return parks;
    }

    public Parking getParkingById(Long id) {
        return parkingRepository.findById(id).get();
    }

    public Parking saveOrUpdateParking(Parking parking) {
    	Parking park = parkingRepository.save(parking);
    	return park;
    }

    public void deleteParking(Long id) {
    	parkingRepository.deleteById(id);
    }
}