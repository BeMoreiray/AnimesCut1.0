package com.projects.animescut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
	@Query("select m from Movies m where m.animes = :animes")
	Movies findByAnimes1(Animes animes);
	
	Optional<Movies> findByAnimes(Animes animes);
}
