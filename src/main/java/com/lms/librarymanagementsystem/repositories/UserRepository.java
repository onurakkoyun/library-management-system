package com.lms.librarymanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.entities.baseEntity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
	
	boolean existsUserByEmail(String email);
}
