package com.dalel.vetements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dalel.vetements.entities.vetements;

public interface VetementsService {
	vetements savevetements(vetements v);
	vetements updatevetements(vetements v);
	void deletevetements(vetements v);
	void deletevetementsById(Long id);
	 vetements getvetements(Long id);
	List<vetements> getAllvetements();
	Page<vetements> getAllvetementsParPage(int page, int size);

}
