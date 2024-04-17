package com.lms.librarymanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.CategoryService;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.responses.AddCategoryResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/categories")
public class CategoriesController {
	private CategoryService categoryService;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddCategoryResponse add(@RequestBody @Valid AddCategoryRequest request) {
        return categoryService.add(request);
    }
}
