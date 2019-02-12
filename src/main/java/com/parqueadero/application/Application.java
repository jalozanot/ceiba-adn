package com.parqueadero.application;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.parqueadero.application.entity.Vigilante;
import com.parqueadero.application.repository.VigilanteRepository;

@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
	@Bean
	public CommandLineRunner inicial (VigilanteRepository repository) {
		return args -> {
			Vigilante vigilante = new Vigilante();
			vigilante.setIdVigilante(Long.parseLong("1"));
			vigilante.setApellido("Rolando");
			vigilante.setNombre("Pedrosqui");
			vigilante.setCedula("1091657");
			repository.save(vigilante);
		};
	}

}

