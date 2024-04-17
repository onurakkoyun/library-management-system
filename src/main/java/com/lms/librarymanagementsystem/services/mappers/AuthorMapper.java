package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.Author;
import com.lms.librarymanagementsystem.services.dtos.authorDtos.requests.AddAuthorRequest;

@Mapper
public interface AuthorMapper {
	AuthorMapper INSTANCE =  Mappers.getMapper(AuthorMapper.class);
	
	Author mapAddAuthorRequestToAuthor(AddAuthorRequest request);
}
