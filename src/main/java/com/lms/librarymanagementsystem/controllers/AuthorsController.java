package com.lms.librarymanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.AuthorService;
import com.lms.librarymanagementsystem.services.dtos.authorDtos.requests.AddAuthorRequest;
import com.lms.librarymanagementsystem.services.dtos.authorDtos.responses.AddAuthorResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/authors")
public class AuthorsController {
	
	private AuthorService authorService;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddAuthorResponse add(@RequestBody @Valid AddAuthorRequest request) {
        return authorService.add(request);
    }
}
