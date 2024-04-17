package com.lms.librarymanagementsystem.services.dtos.bookDtos.requests;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {
	private int bookId;
	
	private String bookName;

	private int edition;

	private int numberOfPages;

	private int unitsInStock;

	private LocalDate releaseDate;

	private List<AssignAuthorRequest> authors;

	private List<AssignCategoryRequest> categories;

	private List<AssignPublisherRequest> publishers;

}
