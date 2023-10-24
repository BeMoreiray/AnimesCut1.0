package com.projects.animescut.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Favorites;
import com.projects.animescut.entities.User;

public interface FavoritesRepository extends JpaRepository<Favorites, Long>{
	
	@Query(value = "select f from Favorites f where f.user.id like %?1%")
	List<Favorites> findFavoritesByUserId(Long userId);
	
	Optional<Favorites> findByUserAndAnimes(User user, Animes animes);
}
