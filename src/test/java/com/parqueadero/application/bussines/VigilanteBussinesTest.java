package com.parqueadero.application.bussines;

import java.util.List;
import java.util.Objects;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.parqueadero.application.entity.Vigilante;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteBussinesTest {
	
	@Autowired
	VigilanteBussines vigilanteBussines;
	


	@Test
	public void guardarVigilante() {
		
		List<Vigilante> respuesta = vigilanteBussines.getAllVigilante();
		Assert.assertTrue(Objects.nonNull(respuesta));
		
	}
	
}
