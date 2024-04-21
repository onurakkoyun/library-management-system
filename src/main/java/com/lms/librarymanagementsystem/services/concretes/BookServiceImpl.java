package com.lms.librarymanagementsystem.services.concretes;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
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
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.SearchBooksByNameResponse;
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

        List<Author> authors = Optional.ofNullable(request.getAuthors()).orElse(Collections.emptyList()).stream()
                .map(BookMapper.INSTANCE::mapAssignAuthorRequestToAuthor).collect(Collectors.toList());
        book.setAuthors(authors);// Authors ile ilişkilendirme.

        List<Category> categories = Optional.ofNullable(request.getCategories()).orElse(Collections.emptyList())
                .stream().map(BookMapper.INSTANCE::mapAssignCategoryRequestToCategory)
                .collect(Collectors.toList());
        book.setCategories(categories);// Categories ile ilişkilendirme.

        List<Publisher> publishers = Optional.ofNullable(request.getPublishers()).orElse(Collections.emptyList())
                .stream().map(BookMapper.INSTANCE::mapAssignPublisherRequestToPublisher)
                .collect(Collectors.toList());
        book.setPublishers(publishers);// Publishers ile ilişkilendirme.

        bookRepository.save(book);

        return new AddBookResponse("Book added.");
    }

    @Override
    public UpdateBookResponse update(UpdateBookRequest request) {
        Book existingBook = BookMapper.INSTANCE.mapUpdateBookRequestToBook(request);

        bookRepository.save(existingBook);

        return new UpdateBookResponse("Book updated.");
    }

    @Override
    public DeleteBookResponse delete(DeleteBookRequest request) {
        bookRepository.deleteById(request.getBookId());

        return new DeleteBookResponse("Book deleted.");
    }

    @Override
    public List<ListBookResponse> getAll() {
        List<Book> books = bookRepository.findAll();

        List<ListBookResponse> response = books.stream().map(BookMapper.INSTANCE::mapBookToListBookResponse)
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public List<SearchBooksByNameResponse> searchBooks(String searchText) {

        List<Book> books = bookRepository.searchBooks(searchText);

        List<SearchBooksByNameResponse> response = books.stream().map(BookMapper.INSTANCE::mapBookToSearchBooksByNameResponse)
                .collect(Collectors.toList());

        return response;
    }

    @Override
    public void increaseBorrowingInStock(int bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BusinessException("Requested book is not found!"));

        book.setBorrowedInStock(book.getBorrowedInStock() + 1);

        bookRepository.save(book);
    }

    @Override
    public void decreaseBorrowingInStock(int bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BusinessException("Requested book is not found!"));

        book.setBorrowedInStock(book.getBorrowedInStock() - 1);

        bookRepository.save(book);

    }
}
