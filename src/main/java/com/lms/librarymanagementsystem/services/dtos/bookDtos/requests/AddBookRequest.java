package com.lms.librarymanagementsystem.services.dtos.bookDtos.requests;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookRequest {
	
	@NotBlank(message = "Kitap isimi alanı boş olamaz.")
	private String bookName;
	
	@Size(min = 10, max = 13, message = "ISBN numarası 10 ile 13 karakter arasında olmalıdır")
    @Pattern(regexp = "^[0-9]+$", message = "ISBN numarası sadece rakamlardan oluşmalıdır")
	private String isbn;
	
	@Positive(message = "Baskı sayısı 1'den küçük olamaz.")
	private int edition;
	
	@Positive(message = "Sayfa sayısı 1'den küçük olamaz.")
	private int numberOfPages;
	
	@PositiveOrZero(message = "Stok miktarı 0'dan küçük olamaz.")
	private int unitsInStock;
	
	@Past(message = "Yayın tarihi geçmiş bir tarih olmalı.")
	private LocalDate releaseDate;
	
	private int publisherId;
	
	private List<AssignAuthorRequest> authors;
	
	private List<AssignCategoryRequest> categories;
}
