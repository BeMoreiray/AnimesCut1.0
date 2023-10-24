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

import com.projects.animescut.entities.Series;
import com.projects.animescut.services.SeriesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/series")
public class SeriesController {
	
	@Autowired
	SeriesService service;
	Series result;
	
	@GetMapping
	public List<Series> getAllSeries(){
		List<Series> result = service.findAllSeries();
		return result;
	}
	
	@GetMapping(value = "/findById/{id}")
	public Series getSeriesById(@PathVariable Long id) {
		Series result = service.findSeriesById(id);
		return result;
	}
	
	@PostMapping("/save")
	public Series saveSeries(@Valid @RequestBody Series serie) {
		Series result = service.insertNewObject(serie);
		return result;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateSeries(@PathVariable Long id, @RequestBody Series updatedSeries) {
		Series serie = service.findSeriesById(id);
		if(serie == null) {
			return ResponseEntity.notFound().build();
		}
		
		// Atualiza o anime com os valores fornecidos pelo objeto updateAnime
		serie.setNumberEpisodes(updatedSeries.getNumberEpisodes());
		serie.setNumberSeasons(updatedSeries.getNumberSeasons());
		serie.setAnimes(updatedSeries.getAnimes());
		
		 result = service.updateSeries(id, serie);
		
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o serie de anime");
        }

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSeries(@PathVariable Long id){
		boolean deleted = service.deleteSeriesById(id);
		if(deleted) {
			return ResponseEntity.ok("Serie excluída com sucesso.");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
