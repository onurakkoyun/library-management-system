package com.lms.librarymanagementsystem.services.dtos.memberDtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberRequest {

	@NotNull(message = "İsim alanı boş olamaz.")
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "İsim sadece harf veya boşluk içerebilir.")
	private String firstName;

	@NotNull(message = "Soyisim alanı boş olamaz.")
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ]+$", message = "Soyisim sadece harf içermelidir.")
	private String lastName;

	@NotNull(message = "Telefon numarası alanı boş olamaz.")
	//@Pattern(regexp = "^\\\\+905[0-9]{2}-[0-9]{3}-[0-9]{4}$", message = "Geçerli bir Türkiye cep telefonu numarası giriniz (Örnek: +905XX-XXX-XXXX)")
	private String phoneNumber;
	
	@Email(message = "Geçerli bir mail formatı girin.")
	private String email;

	@Size(min = 11, max = 11, message = "Kimlik numarası 11 haneli olmalıdır")
	// @Pattern(regexp = "^(?=.*[1-9])(?=.*\\b(0[1-9]|1[0-2])\\b)\\d{11}$", message
	// = "Geçersiz kimlik numarası formatı")
	private String identityNumber;

	private int yearOfBirth;

}
