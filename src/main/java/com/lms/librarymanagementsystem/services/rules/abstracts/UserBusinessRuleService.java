package com.lms.librarymanagementsystem.services.rules.abstracts;

public interface UserBusinessRuleService {
	void checkIfEmailAlreadyExists(String email);
	
	void checkIfPasswordsMatch(String password, String passwordConfirm);
}
