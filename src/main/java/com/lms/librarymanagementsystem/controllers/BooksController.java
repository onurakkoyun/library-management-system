package com.lms.librarymanagementsystem.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.lms.librarymanagementsystem.services.abstracts.BookService;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.DeleteBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.AddBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.DeleteBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.ListBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.SearchBooksByNameResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.UpdateBookResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/books")
public class BooksController {
	
	private BookService bookService;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddBookResponse add(@RequestBody @Valid AddBookRequest request) {
        return bookService.add(request);
    }
	

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdateBookResponse update(@RequestBody @Valid UpdateBookRequest request) {
        return bookService.update(request);
    }
    
    @DeleteMapping("/deleteById")
    @ResponseStatus(HttpStatus.OK)
    public DeleteBookResponse delete(DeleteBookRequest request) {
        return bookService.delete(request);
    }
    
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ListBookResponse> getAll() {
        return bookService.getAll();
    }
    
    @GetMapping("/search-book")
    @ResponseStatus(HttpStatus.OK)
    public List<SearchBooksByNameResponse> searchBooks(@RequestParam String searchText) {
        return bookService.searchBooks(searchText);
    }
    
}
