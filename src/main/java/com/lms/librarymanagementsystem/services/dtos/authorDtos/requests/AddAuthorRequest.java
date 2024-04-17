package com.lms.librarymanagementsystem.services.dtos.authorDtos.requests;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAuthorRequest {
	
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "İsim sadece harf veya boşluk içerebilir.")
	private String firstName;

	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "Soyisim sadece harf içermelidir.")
	private String lastName;
	
	@Past
	private LocalDate dateOfBirth;
	
	@Past
	private LocalDate dateOfDeath;
	
	private String nationality;
	
	private String aboutAuthor;
}
