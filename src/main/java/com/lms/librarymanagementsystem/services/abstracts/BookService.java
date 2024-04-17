package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.AddBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.requests.UpdateBookRequest;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.AddBookResponse;
import com.lms.librarymanagementsystem.services.dtos.bookDtos.responses.UpdateBookResponse;

public interface BookService {
	AddBookResponse add(AddBookRequest request);
	
	UpdateBookResponse update(UpdateBookRequest request);
}
