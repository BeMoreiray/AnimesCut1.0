package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.animescut.entities.Favorites;
import com.projects.animescut.exceptions.DuplicationException;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.repositories.FavoritesRepository;

import jakarta.transaction.Transactional;

@Service
public class FavoritesService {
	@Autowired
	FavoritesRepository repository;
	
	public List<Favorites> findAllFavorites(){
		List<Favorites> result = repository.findAll();
		return result;
	};
	
	public Favorites findById(Long id) {
		Optional<Favorites> optional =  repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Objeto não encontrado com o ID informado! Tente novamente");
		}
	}
	
	public Favorites insertNewObject(Favorites favorites) {
		 if(existsDuplicationFavorites(favorites)) {
			 throw  new DuplicationException("Esse Anime já foi Favoritado por esse Usario anteriormente!");
		 }
		return repository.save(favorites);
	}
	
	protected boolean existsDuplicationFavorites(Favorites fav) {
		Optional<Favorites> existingFav = repository.findByUserAndAnimes(fav.getUser(),fav.getAnimes());
		return existingFav.isPresent();
	}
	
	@Transactional
	public Favorites updateFavorites(Long id, Favorites favorites) {
		Favorites result = repository.findById(id).orElse(null);
		if(result != null) {
			result.setUser(favorites.getUser());
			result.setAnimes(favorites.getAnimes());
			
			return repository.save(result);
			
		}
		return null;
	}
	
	@Transactional
	public boolean deleteFavoritesById(Long id) {
		Favorites result = this.findById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
		
	}
	
	public List<Favorites> searchFavoritesByUserId(Long userId){
		return repository.findFavoritesByUserId(userId);
	}
	
	
}
