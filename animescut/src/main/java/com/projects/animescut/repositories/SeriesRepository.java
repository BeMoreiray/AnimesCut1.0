package com.projects.animescut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
	@Query("select s from Series s where s.animes = :animes")
	Series findByAnimes1(Animes animes);
	
	Optional<Series> findByAnimes(Animes animes);
	 
	 
	 
}
