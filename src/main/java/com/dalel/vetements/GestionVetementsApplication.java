package com.dalel.vetements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dalel.vetements.entities.vetements;
import com.dalel.vetements.service.VetementsService;

@SpringBootApplication
public class GestionVetementsApplication implements CommandLineRunner{
	@Autowired
	VetementsService vetementsService;
	public static void main(String[] args) {
		SpringApplication.run(GestionVetementsApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	//vetementsService.savevetements(new vetements(null, "robe",99.900,new Date()," rose"));
	//vetementsService.savevetements(new vetements(null,"folare",99.900,new Date()," vert"));
	//vetementsService.savevetements(new vetements(null,"sac",99.900,new Date()," bleu"));

}
	}
	