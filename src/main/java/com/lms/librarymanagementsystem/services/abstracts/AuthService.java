package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.LoginRequest;

public interface AuthService {	
    String login(LoginRequest request);
}
