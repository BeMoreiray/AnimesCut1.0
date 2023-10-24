package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.exceptions.DuplicationException;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.repositories.AnimesRepository;

import jakarta.transaction.Transactional;


@Service
@Validated 
public class AnimesService {
	
	@Autowired
	AnimesRepository repository;
	
	
	public List<Animes> findAll() {
		List<Animes> result =  repository.findAll();
		return result;
	}
	
	public Animes findById(Long id) {
		Optional<Animes> optionalAnime =  repository.findById(id);
		if(optionalAnime.isPresent()) {
			return optionalAnime.get();
		}else {
			throw new ResourceNotFoundException("Anime não encontrado com o ID informado! Tente novamente");
		}
		
		
	}
	/*---------------------------CADASTRAR------------------------------------------*/
	public Animes insertNewObject(Animes anime) {
		checkDuplication(anime);
		return repository.save(anime);
	}
	
	private void checkDuplication(Animes anime) {
		String title = anime.getTitle();
		String link = anime.getLink();
		String description = anime.getDescription();
		
		if(repository.findByTitle(title).isPresent()) {
			throw new DuplicationException("Esse TITULO de anime já foi salvo anteriormente!");
		}else if(repository.findByLink(link).isPresent()) {
			throw new DuplicationException("Esse LINK de anime já foi salvo anteriormente!");
		}else if(repository.findByDescription(description).isPresent()) {
			throw new DuplicationException("Essa DESCRIÇÃO de anime já foi salva anteriormente!");
		}
	}
	
	/*-----------------------------------------------------------------*/
	@Transactional
	public Animes updateAnimes(Long id, Animes anime) {
		Animes result = repository.findById(id).orElse(null);
		
		if(result != null) {
			result.setTitle(anime.getTitle());
			result.setLink(anime.getLink());
			result.setReleaseYear(anime.getReleaseYear());
			result.setDescription(anime.getDescription());
			result.setStudio(anime.getStudio());
			result.setCreator(anime.getCreator());
			result.setTypes(anime.getTypes());;
		
			
			return repository.save(result);
			
		}
		return null;
	}
	
	@Transactional
	public boolean deleteAnimesById(Long id) {
		Animes result = findById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
		
	}
	
	public List<Animes> seacrhAnimesByTitle(String title){
		return repository.findAnimesByTitle(title);
	}
	
	
	
	
}
