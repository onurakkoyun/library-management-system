package com.lms.librarymanagementsystem.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.AuthService;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.LoginRequest;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.RegisterRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}

	@PostMapping("register")
	public void register(@RequestBody RegisterRequest request) {
		authService.register(request);
	}
}
