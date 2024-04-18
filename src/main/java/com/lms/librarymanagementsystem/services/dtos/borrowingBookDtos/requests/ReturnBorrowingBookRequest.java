package com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnBorrowingBookRequest {
	private int bookId;
	
	private int memberId;
}
