package com.dalel.vetements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dalel.vetements.entities.vetements;
import com.dalel.vetements.repos.VetementsRepository;

@Service
public class vetementsServiceImpl implements VetementsService{

	@Autowired
	VetementsRepository vetementsRepository;
	
	
	
	@Override
	public vetements savevetements(vetements v) {
		
		return vetementsRepository.save(v);
	}

	@Override
	public vetements updatevetements(vetements v) {
		
		return vetementsRepository.save(v);
	}

	@Override
	public void deletevetements(vetements v) {
		vetementsRepository.delete(v);
		
	}

	@Override
	public void deletevetementsById(Long id) {
		vetementsRepository.deleteById(id);
		
	}

	@Override
	public vetements getvetements(Long id) {
		
		return vetementsRepository.findById(id).get();

	}

	@Override
	public List<vetements> getAllvetements() {
		
		return vetementsRepository.findAll();
	}

	@Override
	public Page<vetements> getAllvetementsParPage(int page, int size) {
	
		return vetementsRepository.findAll(PageRequest.of(page, size));

	}

	
	
	
	
}
