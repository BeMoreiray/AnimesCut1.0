package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.User;
import com.projects.animescut.exceptions.DuplicationException;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Validated
public class UserService {
	
	@Autowired
	UserRepository repository; 
	
	public List<User> findAllUsers(){
		List<User> result = repository.findAll();
		return result;
	}
	

	public User findUsersById(Long id) {
		Optional<User> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Usuário não encontrado!");
		}
	}

/*---------------------------CADASTRAR--------------------------------*/	
	public User insertNewUserObject(User user) {
		String email = user.getEmail();
		String userName = user.getUserName();
		
		if(repository.findByEmail(email).isPresent()) {
			throw new DuplicationException("Esse email já existe!");
		}else if(repository.findByUserName(userName).isPresent()){
			throw new DuplicationException("Esse nome de usuário já existe!");
		}
		
		return repository.save(user);
	}

	
	@Transactional
	public User updateUser(Long id, User user) {
		User result = repository.findById(id).orElse(user);
		if(result != null) {
			result.setUserName(user.getUserName());
			result.setEmail(user.getEmail());
			result.setPassword(user.getPassword());
			
			return repository.save(result);
		}
		return null;
	}
	
	@Transactional
	public boolean deleteUserById(Long id) {
		User result = findUsersById(id);
		if(result != null) {
			repository.delete(result);
			return true;
		}else {
			return false;
		}
	}
	
	public User authenticate(String email, String password) {
		User result = repository.findByEmailAndPassword(email, password);
		return result;
	}
}
