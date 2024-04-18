package com.lms.librarymanagementsystem.services.dtos.authorDtos.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListAuthorResponse {
	private String firstName;

	private String lastName;
	
	private LocalDate dateOfBirth;
	
	private LocalDate dateOfDeath;
	
	private String nationality;
	
	private String aboutAuthor;
}
