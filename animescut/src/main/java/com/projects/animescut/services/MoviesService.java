package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Movies;
import com.projects.animescut.exceptions.DuplicationException;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.repositories.MoviesRepository;

import jakarta.transaction.Transactional;

@Service
public class MoviesService {
	@Autowired
	MoviesRepository repository; 
	
	public List<Movies> findAllMovies(){
		List<Movies> result = repository.findAll();
		return result;
	}
	
	public Movies findMoviesById(Long id) {
		Optional<Movies> optional =  repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Filme de Animes não encontrado com o ID informado! Tente novamente");
		}
	}

/*------------------------Cadastrar-----------------------------------*/
	public Movies insertNewObject(Movies movie) {
		if(existDuplicationMovies(movie)) {
			throw new DuplicationException("Esse Anime já foi salvo como um Filme! Tente outro.");
		}
		
		return repository.save(movie);
		
	}
/*---------------------------------------------------*/
	protected boolean existDuplicationMovies(Movies movie) {
		Optional<Movies> existingMovie = repository.findByAnimes(movie.getAnimes());
		return existingMovie.isPresent();
	}
	
	@Transactional
	public Movies updateMovies(Long id, Movies movies) {
		Movies result = repository.findById(id).orElse(null);
		if(result != null) {
			result.setDuarationMin(movies.getDuarationMin());
			result.setAnimes(movies.getAnimes());
			
			return repository.save(result);
			
		}
		return null;
	}
	
	@Transactional
	public boolean deleteMoviesById(Long id) {
		Movies result = findMoviesById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
		
	}
	
	public Movies getMoviesByAnimes(Animes anime) {
		return repository.findByAnimes1(anime);
	}
}
