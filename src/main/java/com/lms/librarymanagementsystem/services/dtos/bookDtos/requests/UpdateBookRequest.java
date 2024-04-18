package com.lms.librarymanagementsystem.services.dtos.bookDtos.requests;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBookRequest {
	private int bookId;
	
	@NotBlank(message = "Kitap isimi alanı boş olamaz.")
	private String bookName;

	@Positive(message = "Baskı sayısı 1'den küçük olamaz.")
	private int edition;

	@Positive(message = "Sayfa sayısı 1'den küçük olamaz.")
	private int numberOfPages;

	@PositiveOrZero(message = "Stok miktarı 0'dan küçük olamaz.")
	private int unitsInStock;

	@Past(message = "Yayın tarihi geçmiş bir tarih olmalı.")
	private LocalDate releaseDate;

	private List<AssignAuthorRequest> authors;

	private List<AssignCategoryRequest> categories;

	private List<AssignPublisherRequest> publishers;

}
