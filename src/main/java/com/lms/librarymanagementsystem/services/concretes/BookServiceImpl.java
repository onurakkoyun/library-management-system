package com.lms.librarymanagementsystem.services.concretes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.entities.Author;
import com.lms.librarymanagementsystem.entities.Book;
import com.lms.librarymanagementsystem.entities.Category;
import com.lms.librarymanagementsystem.entities.Publisher;
import com.lms.librarymanagementsystem.repositories.BookRepository;
import com.lms.librarymanagementsystem.services.abstracts.BookService;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.DeleteBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.AddBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.DeleteBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.ListBookResponse;
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

		List<Author> authors = Optional.ofNullable(request.getAuthors())
				.orElse(Collections.emptyList()).stream()
				.map(author -> BookMapper.INSTANCE.mapAssignAuthorRequestToAuthor(author))
				.collect(Collectors.toList());
		book.setAuthors(authors);// Authors ile ilişkilendirme.

		List<Category> categories = Optional.ofNullable(request.getCategories()).orElse(Collections.emptyList())
				.stream().map(category -> BookMapper.INSTANCE.mapAssignCategoryRequestToCategory(category))
				.collect(Collectors.toList());
		book.setCategories(categories);// Categories ile ilişkilendirme.

		List<Publisher> publishers = Optional.ofNullable(request.getPublishers()).orElse(Collections.emptyList())
				.stream().map(publisher -> BookMapper.INSTANCE.mapAssignPublisherRequestToPublisher(publisher))
				.collect(Collectors.toList());
		book.setPublishers(publishers);// Publishers ile ilişkilendirme.

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

	@Override
	public DeleteBookResponse delete(DeleteBookRequest request) {
		bookRepository.deleteById(request.getBookId());

		DeleteBookResponse response = new DeleteBookResponse("Book deleted.");
		return response;
	}

	@Override
	public List<ListBookResponse> getAll() {
		List<Book> books = bookRepository.findAll();

		List<ListBookResponse> response = books.stream().map(BookMapper.INSTANCE::mapListBookToListBookResponse)
				.collect(Collectors.toList());

		return response;
	}

}
