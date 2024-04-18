package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.AddBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.ReturnBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.AddBorrowingBookResponse;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.ReturnBorrowingBookResponse;

public interface BorrowingBookService {
	AddBorrowingBookResponse add(AddBorrowingBookRequest request);
	
	ReturnBorrowingBookResponse returnBook(ReturnBorrowingBookRequest request);
}
