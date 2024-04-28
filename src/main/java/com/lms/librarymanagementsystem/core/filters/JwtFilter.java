package com.lms.librarymanagementsystem.core.filters;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lms.librarymanagementsystem.core.services.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String jwtHeader = request.getHeader("Authorization");

		if (jwtHeader != null && jwtHeader.startsWith("Bearer ")) {
			// Bearer abc
			String jwt = jwtHeader.substring(7);

			if (jwtService.validateToken(jwt)) {
				String username = jwtService.extractUsername(jwt);
				// TODO: Rolleri implemente et.
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null,
						null);
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(token);
			}
		}

		filterChain.doFilter(request, response);
	}

}
