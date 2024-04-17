package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.Category;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.requests.AddCategoryRequest;


@Mapper
public interface CategoryMapper {
	CategoryMapper INSTANCE =  Mappers.getMapper(CategoryMapper.class);
	
	Category mapAddCategoryRequestToCategory(AddCategoryRequest request);
	
}
