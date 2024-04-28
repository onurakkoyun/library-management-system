package com.lms.librarymanagementsystem.services.dtos.bookDtos.responses;

import java.time.LocalDate;
import java.util.List;

import com.lms.librarymanagementsystem.services.dtos.authorDtos.responses.ListAuthorResponse;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.responses.ListCategoryResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBookResponse {
	
	private String bookName;
	
	private String isbn;
	
	private int edition;
	
	private int numberOfPages;
	
	private int unitsInStock;
	
	private LocalDate releaseDate;
	
	private String publisherName;
	
	private List<ListCategoryResponse> categories;
	
	private List<ListAuthorResponse> authors;	
}
