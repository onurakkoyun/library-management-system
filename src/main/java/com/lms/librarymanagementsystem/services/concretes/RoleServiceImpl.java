package com.lms.librarymanagementsystem.services.concretes;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.entities.ERole;
import com.lms.librarymanagementsystem.entities.Role;
import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
import com.lms.librarymanagementsystem.repositories.RoleRepository;
import com.lms.librarymanagementsystem.services.abstracts.RoleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{
	
	private RoleRepository roleRepository;

	@Override
	public Role getByRoleName(ERole roleName) {
		Role role = roleRepository.findByRoleName(roleName)
				.orElseThrow(() -> new BusinessException("Error: Role is not found."));
		return role;
	}
}
