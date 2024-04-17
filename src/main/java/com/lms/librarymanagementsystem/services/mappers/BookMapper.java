package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.Author;
import com.lms.librarymanagementsystem.entities.Book;
import com.lms.librarymanagementsystem.entities.Category;
import com.lms.librarymanagementsystem.entities.Publisher;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignAuthorRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignCategoryRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignPublisherRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;

@Mapper
public interface BookMapper {
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
	
	Book mapAddBookRequestToBook(AddBookRequest request);
	
	@Mapping(target = "id", source = "authorId")
	Author mapAssignAuthorRequestToAuthor(AssignAuthorRequest request);
	
	@Mapping(target = "id", source = "categoryId")
	Category mapAssignCategoryRequestToCategory(AssignCategoryRequest request);
	
	@Mapping(target = "id", source = "publisherId")
	Publisher mapAssignPublisherRequestToPublisher(AssignPublisherRequest request);
	
	@Mapping(target = "id", source = "bookId")
	Book mapUpdateBookRequestToBook(UpdateBookRequest request);
}
