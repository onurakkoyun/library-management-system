package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.LoginRequest;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.RegisterRequest;

public interface AuthService {
	
	void register(RegisterRequest request);
	
    String login(LoginRequest request);
}
