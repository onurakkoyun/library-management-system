package com.lms.librarymanagementsystem.services.concretes;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.entities.Category;
import com.lms.librarymanagementsystem.repositories.CategoryRepository;
import com.lms.librarymanagementsystem.services.abstracts.CategoryService;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.responses.AddCategoryResponse;
import com.lms.librarymanagementsystem.services.mappers.CategoryMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepository;
	
	@Override
	public AddCategoryResponse add(AddCategoryRequest request) {

		Category category = CategoryMapper.INSTANCE.mapAddCategoryRequestToCategory(request);
		
		categoryRepository.save(category);
		
		AddCategoryResponse response = new AddCategoryResponse("Category added.");

		return response;
	}

}
