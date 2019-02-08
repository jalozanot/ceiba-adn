package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.application.repository.ParkingRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ParkingRepository.class)
public class DemoApplicationTests {

	@Test
	public void insertarVehiculo() {
		assertEquals(5, 5);
	}

}

