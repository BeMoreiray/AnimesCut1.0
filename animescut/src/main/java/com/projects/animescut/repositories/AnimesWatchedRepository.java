package com.projects.animescut.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.AnimesWatched;
import com.projects.animescut.entities.User;

public interface AnimesWatchedRepository extends JpaRepository<AnimesWatched, Long>{
	
	@Query(value="select aw from AnimesWatched aw where aw.user.id like %?1%")
	List<AnimesWatched> findAnimesWatchedByUserId(Long userId);
	
	Optional<AnimesWatched> findByUserAndAnimes(User user, Animes animes);
	
}
