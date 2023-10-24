package com.projects.animescut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.TypesAnimes;

public interface TypesAnimesRepository extends JpaRepository<TypesAnimes, Long> {
	Optional<TypesAnimes> findByTitle(String title);
 }
