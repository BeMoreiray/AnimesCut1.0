package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
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
	MoviesRepository repository = new MoviesRepository() {
		
		@Override
		public <S extends Movies> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		
		@Override
		public <S extends Movies, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Movies> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Movies> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public <S extends Movies> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Page<Movies> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Movies> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Movies> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Movies> findById(Long id) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		
		@Override
		public boolean existsById(Long id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(Long id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllById(Iterable<? extends Long> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll(Iterable<? extends Movies> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Movies entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends Movies> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Movies> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Movies> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Movies> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Movies> List<S> saveAllAndFlush(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Movies getReferenceById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Movies getOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Movies getById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public <S extends Movies> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Movies> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void deleteAllInBatch(Iterable<Movies> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllInBatch() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAllByIdInBatch(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Movies findByAnimes1(Animes animes) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Movies> findByAnimes(Animes animes) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
	};
	
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
