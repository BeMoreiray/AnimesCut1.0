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

import com.projects.animescut.entities.AnimesWatched;
import com.projects.animescut.services.AnimesWatchedService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/animesWatched")
public class AnimesWatchedController {
	
	@Autowired
	AnimesWatchedService service;
	AnimesWatched result;
	
	@GetMapping
	public List<AnimesWatched> getAllAnimesWatched(){
		List<AnimesWatched> result = service.findAllAnimesWatched();
		return result;
	}
	
	@GetMapping(value = "/findById/{id}")
	public AnimesWatched getAnimesWatchedyId(@PathVariable Long id) {
		AnimesWatched result = service.findById(id);
		return result;
	}
	
	@PostMapping("/save")
	public AnimesWatched insertAnimesWatched(@Valid @RequestBody AnimesWatched animesW) {
		AnimesWatched result = service.insertNewObject(animesW);
		return result;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateAnimesWatched(@PathVariable Long id, @RequestBody AnimesWatched updatedAnimesW) {
		AnimesWatched animesW = service.findById(id);
		if(animesW == null) {
			return ResponseEntity.notFound().build();
		}
		
		// Atualiza o anime com os valores fornecidos pelo objeto updateAnime
		animesW.setUser(updatedAnimesW.getUser());
		animesW.setAnimes(updatedAnimesW.getAnimes());
		
		 result = service.updateAnimesWatched(id, animesW);
		
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar!");
        }

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAnimesWatched(@PathVariable Long id){
		boolean deleted = service.deleteAnimesWatchedById(id);
		if(deleted) {
			return ResponseEntity.ok("Exclusão feito com sucesso");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value="/searchByUserId/{userId}")
	public ResponseEntity<List<AnimesWatched>> searchAnimesWachedByUserId(@PathVariable Long userId){
		List<AnimesWatched> result = service.searchAnimesWatchedByUserId(userId);
		
		if(result != null) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
