package com.lms.librarymanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.core.utilities.entities.ERole;
import com.lms.librarymanagementsystem.core.utilities.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByRoleName(ERole roleName);
}
