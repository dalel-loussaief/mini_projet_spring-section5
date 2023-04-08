package com.dalel.vetements.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dalel.vetements.entities.vetements;

public interface VetementsRepository extends JpaRepository<vetements, Long> {

}
