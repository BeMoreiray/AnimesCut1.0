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
import com.projects.animescut.entities.Series;
import com.projects.animescut.exceptions.DuplicationException;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.repositories.SeriesRepository;

import jakarta.transaction.Transactional;

@Service
public class SeriesService {
	@Autowired
	SeriesRepository repository = new SeriesRepository() {
		
		@Override
		public <S extends Series> Optional<S> findOne(Example<S> example) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
		
		@Override
		public <S extends Series, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Series> Page<S> findAll(Example<S> example, Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Series> boolean exists(Example<S> example) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public <S extends Series> long count(Example<S> example) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Page<Series> findAll(Pageable pageable) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Series> findAll(Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Series> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Series> findById(Long id) {
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
		public void deleteAll(Iterable<? extends Series> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(Series entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public <S extends Series> List<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Series> findAllById(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Series> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Series> S saveAndFlush(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Series> List<S> saveAllAndFlush(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Series getReferenceById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Series getOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Series getById(Long id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void flush() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public <S extends Series> List<S> findAll(Example<S> example, Sort sort) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends Series> List<S> findAll(Example<S> example) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void deleteAllInBatch(Iterable<Series> entities) {
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
		public Series findByAnimes1(Animes animes) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<Series> findByAnimes(Animes animes) {
			// TODO Auto-generated method stub
			return Optional.empty();
		}
	};
	
	public List<Series> findAllSeries(){
		List<Series> result = repository.findAll();
		return result;
	};
	
	public Series findSeriesById(Long id) {
		Optional<Series> optional =  repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Series de Anime não encontrado com o ID informado! Tente novamente");
		}
	}

/*------------------------CADASTRAR-----------------------------*/	
	public Series insertNewObject(Series serie) {
		if(existDuplicationSeries(serie)) {
			throw new DuplicationException("Esse Anime já foi salvo como uma SÉRIE! tente outro.");
		}
		Series result = repository.save(serie);
		return result;
	}
	
	protected boolean existDuplicationSeries(Series serie) {
		Optional<Series> existingSerie = repository.findByAnimes(serie.getAnimes());
		return existingSerie.isPresent();
	}
/*--------------------------------------------------------*/	
	@Transactional
	public Series updateSeries(Long id, Series series) {
		Series result = repository.findById(id).orElse(null);
		if(result != null) {
			result.setNumberEpisodes(series.getNumberEpisodes());
			result.setNumberSeasons(series.getNumberSeasons());
			result.setAnimes(series.getAnimes());
			
			return repository.save(result);
			
		}
		return null;
	}
	
	@Transactional
	public boolean deleteSeriesById(Long id) {
		Series result = findSeriesById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
		
	}
	
	public Series getSeriesByAnimes(Animes anime) {
		return repository.findByAnimes1(anime);
	}
}
