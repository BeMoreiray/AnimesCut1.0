package com.projects.animescut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmailAndPassword(String email, String password);
	
	Optional<User> findByEmail(String email);
	Optional<User> findByUserName(String userName);
}
