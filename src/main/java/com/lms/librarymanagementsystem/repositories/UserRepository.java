package com.lms.librarymanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.core.utilities.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> getByUsername(String username);

	Optional<User> getByEmail(String email);
}
