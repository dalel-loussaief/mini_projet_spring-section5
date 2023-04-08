package com.dalel.vetements;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.dalel.vetements.entities.vetements;
import com.dalel.vetements.repos.VetementsRepository;
import com.dalel.vetements.service.VetementsService;

@SpringBootTest
class GestionVetementsApplicationTests {
	
	@Autowired
	private VetementsRepository VetementsRepository;
	@Autowired
	private VetementsService vetementsService;
	@Test
	public void testCreatevetements() {
	vetements v = new vetements(null,"pantalon",99.900,new Date()," djean");
	VetementsRepository.save(v);
	}
	@Test
	public void testFindvetements()
	{
	vetements v = VetementsRepository.findById(1L).get(); 
	System.out.println(v);
	}
	@Test
	public void testUpdatevetements()
	{
		vetements v = VetementsRepository.findById(1L).get();
	v.setPrixVetements(500.0);
	VetementsRepository.save(v);
	}
	@Test
	public void testDeletevetements()
	{
		VetementsRepository.deleteById(1L);
	}
	 
	@Test
	public void testListerTousvetements()
	{
	List<vetements> vet = VetementsRepository.findAll();
	for (vetements v : vet)
	{
	System.out.println(v);
	}
	}

	@Test
	public void testFindByNomvetementsContains()
	{
	Page<vetements> prods = vetementsService.getAllvetementsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Produit p : prods)
	{
	System.out.println(p);
	} */
	}

	


}
