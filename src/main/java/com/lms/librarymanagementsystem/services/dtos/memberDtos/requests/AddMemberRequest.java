package com.lms.librarymanagementsystem.services.dtos.memberDtos.requests;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberRequest {
	
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "İsim sadece harf veya boşluk içerebilir.")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "Soyisim sadece harf içermelidir.")
	private String lastName;
	
	@Size(min = 11, max = 11, message = "Kimlik numarası 11 haneli olmalıdır")
    //@Pattern(regexp = "^(?=.*[1-9])(?=.*\\b(0[1-9]|1[0-2])\\b)\\d{11}$", message = "Geçersiz kimlik numarası formatı")
	private String identityNumber;

	private int yearOfBirth;

}
