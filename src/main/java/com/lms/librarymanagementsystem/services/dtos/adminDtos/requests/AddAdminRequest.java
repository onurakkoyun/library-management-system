package com.lms.librarymanagementsystem.services.dtos.adminDtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAdminRequest {

	@Email(message = "Geçerli bir mail formatı girin.")
	private String email;

	@NotNull(message = "Şifre alanı boş olamaz.")
	private String password;

	@NotNull(message = "İsim alanı boş olamaz.")
	private String firstName;

	@NotNull(message = "Soyisim alanı boş olamaz.")
	private String lastName;

	@NotNull(message = "Telefon numarası alanı boş olamaz.")
	@Pattern(regexp = "^\\\\+905[0-9]{2}-[0-9]{3}-[0-9]{4}$", message = "Geçerli bir Türkiye cep telefonu numarası giriniz (Örnek: +905XX-XXX-XXXX)")
	private String phoneNumber;
}
