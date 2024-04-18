package com.lms.librarymanagementsystem.services.dtos.bookDtos.responses;

import java.time.LocalDate;
import java.util.List;

import com.lms.librarymanagementsystem.services.dtos.authorDtos.responses.ListAuthorResponse;
import com.lms.librarymanagementsystem.services.dtos.categoryDtos.responses.ListCategoryResponse;
import com.lms.librarymanagementsystem.services.dtos.publisherDto.responses.ListPublisherResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListBookResponse {
	
	private String bookName;
	
	private int edition;
	
	private int numberOfPages;
	
	private int unitsInStock;
	
	private LocalDate releaseDate;
	
	private List<ListCategoryResponse> categories;
	
	private List<ListAuthorResponse> authors;
	
	private List<ListPublisherResponse> publishers;
}
