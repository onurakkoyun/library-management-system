package com.lms.librarymanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.AdminService;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.RegisterAdminRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admins")
public class AdminController {
	
	private AdminService adminService;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public void register(@RequestBody @Valid RegisterAdminRequest request) {
		adminService.register(request);
	}
}
