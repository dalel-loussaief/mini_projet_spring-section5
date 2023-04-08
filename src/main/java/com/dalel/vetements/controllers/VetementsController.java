package com.dalel.vetements.controllers;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dalel.vetements.entities.vetements;
import com.dalel.vetements.service.VetementsService;

@Controller
public class VetementsController {
	
		@Autowired
		VetementsService vetementsService;
		@RequestMapping("/showCreate")
		public String showCreate()
		{
		return "createVetements";
		}
		@RequestMapping("/saveVetement")
		public String saveVetement(@ModelAttribute(" vetements") vetements vetements, 
		 @RequestParam("date") String date,
		 ModelMap modelMap) throws
		ParseException 
		{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateProduction = dateformat.parse(String.valueOf(date));
		 vetements.setDateProduction(dateProduction);
		 
		vetements savevetements = vetementsService.savevetements(vetements);
		String msg ="vetements enregistré avec Id "+savevetements.getIdVetements();
		modelMap.addAttribute("msg", msg);
		return "createvetements";
		}
		@RequestMapping("/ListeVetements")
		public String listeProduits(ModelMap modelMap,
				@RequestParam (name="page",defaultValue = "0") int page,
				@RequestParam (name="size", defaultValue = "2") int size)
		{
		Page<vetements> v = vetementsService. getAllvetementsParPage(page,size);
		modelMap.addAttribute("Vetements", v);
		modelMap.addAttribute("pages", new int[v.getTotalPages()]);
		modelMap.addAttribute("size",size);

		return "listeVetements";
		}
		@RequestMapping("/supprimervetements")
		public String supprimervetements(@RequestParam("id") Long id,
		 ModelMap modelMap,
		 @RequestParam (name="page",defaultValue = "0") int page,
		 @RequestParam (name="size", defaultValue = "2") int size)

		{ 
		vetementsService.deletevetementsById(id);
		Page<vetements> v =vetementsService.getAllvetementsParPage(page, 
				size);
		modelMap.addAttribute("Vetements", v);
		modelMap.addAttribute("pages", new int[v.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size",size);
		return "listeVetements";
		}
		@RequestMapping("/modifiervetements")
		public String editervetements(@RequestParam("id") Long id,ModelMap modelMap)
		{
		vetements v= vetementsService.getvetements(id);
		modelMap.addAttribute("vetements", v);
		return "editerVetements";
		}
		@RequestMapping("/updateVetements")
		public String updatevetements(@ModelAttribute("vetements") vetements vetements,
		@RequestParam("date") String date,
		ModelMap modelMap) throws ParseException 
		{
		//conversion de la date 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateProduction = dateformat.parse(String.valueOf(date));
		 vetements.setDateProduction(dateProduction);
		 
		 vetementsService.updatevetements(vetements);
		 List<vetements> v = vetementsService.getAllvetements();
		 modelMap.addAttribute("vetements",v);
		return "listeVetements";
		}
		
		}


