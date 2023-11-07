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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.dto.AnimesDatailsDTO;
import com.projects.animescut.dto.AnimesLinkDTO;
import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Movies;
import com.projects.animescut.entities.Series;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.services.AnimesService;
import com.projects.animescut.services.MoviesService;
import com.projects.animescut.services.SeriesService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/api/animes")
public class AnimesController {
	
	
	
	@Autowired 
	AnimesService service;
	Animes result;
	Movies movie;
	Series serie;
	MoviesService mService = new MoviesService();
	SeriesService sService = new SeriesService();
	 
	@GetMapping
	public List<Animes> getAllAnimes(){
		List<Animes> result = service.findAll();
		return result;
	}
	
	@GetMapping(value = "/findById/{id}")
	public Animes getAnimesById( @PathVariable Long id) {
		result = service.findById(id);
		return result;
	}
	
	@PostMapping("/save")
	public Animes saveNewAnime(@Valid @RequestBody Animes anime) { 
		result = service.insertNewObject(anime);
		return result;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateAnimes(@PathVariable Long id, @RequestBody Animes updatedAnime) {
		Animes anime = service.findById(id);
		if(anime == null) {
			return ResponseEntity.notFound().build();
		}
		
		// Atualiza o anime com os valores fornecidos pelo objeto updateAnime
		anime.setTitle(updatedAnime.getTitle());
		anime.setLink(updatedAnime.getLink());
		anime.setReleaseYear(updatedAnime.getReleaseYear());
		anime.setDescription(updatedAnime.getDescription());
		anime.setStudio(updatedAnime.getStudio());
		anime.setCreator(updatedAnime.getCreator());
		
		 result = service.updateAnimes(id, anime);
		
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o anime");
        }

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAnimes(@PathVariable Long id){
		boolean deleted = service.deleteAnimesById(id);
		if(deleted) {
			return ResponseEntity.ok("Anime excluído com sucesso.");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/searchForAnimesNames")
	public ResponseEntity<List<AnimesLinkDTO>> searchAnimesBy(@RequestParam("title") String title){
		List<AnimesLinkDTO> result = service.seacrhAnimesByTitle(title.trim().toUpperCase());
		
		if(result != null) {
		return  ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/displayAnimesDatails/{id}")
	public AnimesDatailsDTO getAnimeDatails(@PathVariable Long id) {
		result = service.findById(id);
		
		AnimesDatailsDTO dto = new AnimesDatailsDTO();
		if(result != null) {
			dto.setTitle(result.getTitle());
			dto.setLink(result.getLink());
			dto.setDescription(result.getDescription());
			dto.setReleaseYear(result.getReleaseYear());
			dto.setStudio(result.getStudio());
			dto.setCreator(result.getCreator());
		
			movie = mService.getMoviesByAnimes(result);
			if(movie != null) {
				dto.setDuarationMin(movie.getDuarationMin());
			}
			serie = sService.getSeriesByAnimes(result);
			if(serie != null) {
				dto.setNumberEpisodes(serie.getNumberEpisodes());
				dto.setNumberSeasons(serie.getNumberSeasons());
			}
			return dto;
		}else {
			throw new ResourceNotFoundException("Detalhes do anime buscado não foi encontrado!");
		}
		
	}
	
	@GetMapping("/getAllAnimesLinkDTO")
	public List<AnimesLinkDTO> getAllAnimesLinkDTO(){
		return service.findAllAnimesLinkDTO();
	}
	
	
	
}
