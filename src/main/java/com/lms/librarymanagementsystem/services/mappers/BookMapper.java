package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.Author;
import com.lms.librarymanagementsystem.entities.Book;
import com.lms.librarymanagementsystem.entities.Category;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignAuthorRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignCategoryRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.ListBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.SearchBooksByNameResponse;

@Mapper
public interface BookMapper {
	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
	
	@Mapping(target = "publisher.id", source = "publisherId")
	Book mapAddBookRequestToBook(AddBookRequest request);
	
	@Mapping(target = "id", source = "authorId")
	Author mapAssignAuthorRequestToAuthor(AssignAuthorRequest request);
	
	@Mapping(target = "id", source = "categoryId")
	Category mapAssignCategoryRequestToCategory(AssignCategoryRequest request);
	
	@Mapping(target = "id", source = "bookId")
	@Mapping(target = "publisher.id", source = "publisherId")
	Book mapUpdateBookRequestToBook(UpdateBookRequest request);
	
	@Mapping(target = "publisherName", source = "publisher.publisherName")
    ListBookResponse mapBookToListBookResponse(Book book);
    
	@Mapping(target = "publisherName", source = "publisher.publisherName")
    SearchBooksByNameResponse mapBookToSearchBooksByNameResponse(Book book);
}
