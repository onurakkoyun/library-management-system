package com.lms.librarymanagementsystem.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.BookService;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.DeleteBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.AddBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.DeleteBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.ListBookResponse;
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
}
