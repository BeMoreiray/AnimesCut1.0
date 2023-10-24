package com.projects.animescut.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.TypesAnimes;
import com.projects.animescut.exceptions.DuplicationException;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.repositories.TypesAnimesRepository;

import jakarta.transaction.Transactional;

@Service
@Validated //anotação utilizada para auxiliar @notnull e @notBlank, permite que a validação seja feita
public class TypesAnimesService {
	
	@Autowired
	TypesAnimesRepository repository;
	
	public List<TypesAnimes> findAll(){
		List<TypesAnimes> result = repository.findAll();
		return result;
	}
	
	public TypesAnimes findById(Long id) {
		Optional<TypesAnimes> optionalTypesAnimes = repository.findById(id);
		if(optionalTypesAnimes.isPresent()) {
			return optionalTypesAnimes.get();
		}else {
			throw new ResourceNotFoundException("Categoria de anime não encontrada com o ID informado! Tente novamente");
		}
	}
	
	public TypesAnimes insertNewObject(TypesAnimes types) {
		if(existsDuplicationTypesAnimes(types)) {
			throw new DuplicationException("Este Tipo já foi salvo! Tente novamente.");
		}
		
		return repository.save(types);
	}
	
	protected boolean existsDuplicationTypesAnimes(TypesAnimes ta) {
		Optional<TypesAnimes> existingTA = repository.findByTitle(ta.getTitle());
				return existingTA.isPresent();
	}
	
	@Transactional
	public TypesAnimes updateTypes(Long id, TypesAnimes types) {
		TypesAnimes result = findById(id); //refatoração (obs. diferente da classe animeService)
		if(result != null) {
			result.setTitle(types.getTitle());
			
			return repository.save(result);
		}
		return null;
	}
	
	@Transactional
	public boolean deleteTypesAnimes(Long id) {
		TypesAnimes result = findById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
	}
	
}
