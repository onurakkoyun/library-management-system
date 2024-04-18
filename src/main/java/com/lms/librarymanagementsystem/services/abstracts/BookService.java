package com.lms.librarymanagementsystem.services.abstracts;

import java.util.List;

import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.DeleteBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.AddBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.DeleteBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.ListBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.UpdateBookResponse;

public interface BookService {
	AddBookResponse add(AddBookRequest request);
	
	UpdateBookResponse update(UpdateBookRequest request);
	
	DeleteBookResponse delete(DeleteBookRequest request);
	
	List<ListBookResponse> getAll();
}
