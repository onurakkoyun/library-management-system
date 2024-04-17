package com.lms.librarymanagementsystem.services.rules.abstracts;

public interface UserBusinessRuleService {
	void checkIfUsernameAlreadyExists(String username);

	void checkIfEmailAlreadyExists(String email);
}
