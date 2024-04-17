package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.categoryDtos.requests.AddCategoryRequest;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.responses.AddCategoryResponse;

public interface CategoryService {
	AddCategoryResponse add(AddCategoryRequest request);
}
