package com.lms.librarymanagementsystem.services.concretes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.core.services.JwtService;
import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
import com.lms.librarymanagementsystem.entities.baseEntity.User;
import com.lms.librarymanagementsystem.repositories.UserRepository;
import com.lms.librarymanagementsystem.services.abstracts.AuthService;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.LoginRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final UserRepository userRepository;

	private final AuthenticationManager authenticationManager;

	private final JwtService jwtService;

	@Override
	public String login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new BusinessException("E-posta ya da şifre yanlış.."));

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		if (!authentication.isAuthenticated())
			throw new BusinessException("E-posta ya da şifre yanlış.");

		// TODO: JWT Oluştur ve kullanıcıya ver.
		Map<String, Object> extraClaims = new HashMap<>();
		extraClaims.put("userId", user.getId());
		return jwtService.generateToken(user.getUsername(), extraClaims);
	}

}
