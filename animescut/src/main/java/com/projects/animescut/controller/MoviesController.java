package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Movies;
import com.projects.animescut.services.MoviesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/movies")
public class MoviesController {
	@Autowired
	MoviesService service;
	Movies result;
	
	@GetMapping
	public List<Movies> getAllMovies(){
		List<Movies> result = service.findAllMovies();
		return result;
	}
	
	@GetMapping(value = "/findById/{id}")
	public Movies getMoviesById(@PathVariable Long id) {
		Movies result = service.findMoviesById(id);
		return result;
	}
	
	@PostMapping("/save")
	public Movies saveMovies(@Valid @RequestBody Movies movie) {
		Movies result = service.insertNewObject(movie);
		return result;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateMovies(@PathVariable Long id, @RequestBody Movies updatedMovie) {
		Movies movie = service.findMoviesById(id);
		if(movie == null) {
			return ResponseEntity.notFound().build();
		}
		
		// Atualiza o anime com os valores fornecidos pelo objeto updateAnime
		movie.setDuarationMin(updatedMovie.getDuarationMin());
		movie.setAnimes(updatedMovie.getAnimes());
		
		
		 result = service.updateMovies(id, movie);
		
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o filme de anime");
        }

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMovies(@PathVariable Long id){
		boolean deleted = service.deleteMoviesById(id);
		if(deleted) {
			return ResponseEntity.ok("Filme excluída com sucesso.");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
