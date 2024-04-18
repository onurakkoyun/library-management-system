package com.lms.librarymanagementsystem.services.rules.concretes;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
import com.lms.librarymanagementsystem.repositories.UserRepository;
import com.lms.librarymanagementsystem.services.rules.abstracts.UserBusinessRuleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserBusinessRuleImpl implements UserBusinessRuleService {

	private UserRepository userRepository;
	
	public void checkIfUsernameAlreadyExists(String username) {
		this.userRepository.getByUsername(username).ifPresent(user -> {
			throw new BusinessException(user.getUsername() + " zaten mevcut.");
		});
	}

	public void checkIfEmailAlreadyExists(String email) {
		this.userRepository.getByEmail(email).ifPresent(user -> {
			throw new BusinessException(user.getEmail() + " zaten mevcut.");
		});
	}

}
