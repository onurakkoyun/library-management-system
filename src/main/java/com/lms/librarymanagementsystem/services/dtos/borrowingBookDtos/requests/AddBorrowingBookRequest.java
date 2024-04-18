package com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBorrowingBookRequest {
	private int bookId;
	
	private int memberId;
	
	private LocalDate endDate;
}
