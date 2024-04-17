package com.lms.librarymanagementsystem.services.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.entities.Author;
import com.lms.librarymanagementsystem.entities.Book;
import com.lms.librarymanagementsystem.entities.Category;
import com.lms.librarymanagementsystem.entities.Publisher;
import com.lms.librarymanagementsystem.repositories.BookRepository;
import com.lms.librarymanagementsystem.services.abstracts.BookService;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignAuthorRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignCategoryRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AssignPublisherRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.AddBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.UpdateBookResponse;
import com.lms.librarymanagementsystem.services.mappers.BookMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	
	private BookRepository bookRepository;
	
	@Override
	public AddBookResponse add(AddBookRequest request) {
		
		Book book = BookMapper.INSTANCE.mapAddBookRequestToBook(request);
		
		List<Author> authors = new ArrayList<>();
		List<Category> categories = new ArrayList<>();
		List<Publisher> publishers = new ArrayList<>();
		
		//İş kuralı olarak null'ı kontrol etmeyi yap
		if (request.getAuthors() != null) {
			for (AssignAuthorRequest dto : request.getAuthors()) {
				Author author = BookMapper.INSTANCE.mapAssignAuthorRequestToAuthor(dto);
				authors.add(author);
			}
		}
		book.setAuthors(authors);//Authors ile ilişkilendirme.
		
		if (request.getCategories() != null) {
			for (AssignCategoryRequest dto : request.getCategories()) {
				Category category = BookMapper.INSTANCE.mapAssignCategoryRequestToCategory(dto);
				categories.add(category);
			}
		}
		book.setCategories(categories);//Categories ile ilişkilendirme.
		
		if (request.getPublishers() != null) {
			for (AssignPublisherRequest dto : request.getPublishers()) {
				Publisher publisher = BookMapper.INSTANCE.mapAssignPublisherRequestToPublisher(dto);
				publishers.add(publisher);
			}
		}
		book.setPublishers(publishers);//Publishers ile ilişkilendirme.
		
		
		bookRepository.save(book);
		
		AddBookResponse response = new AddBookResponse("Book added.");
		
		return response;
	}

	@Override
	public UpdateBookResponse update(UpdateBookRequest request) {
		Book existingBook = BookMapper.INSTANCE.mapUpdateBookRequestToBook(request);
		
		bookRepository.save(existingBook);

		UpdateBookResponse response = new UpdateBookResponse("Book updated.");

		return response;
	}
	
}
