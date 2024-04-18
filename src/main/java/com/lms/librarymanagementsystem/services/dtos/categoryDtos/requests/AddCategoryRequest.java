package com.lms.librarymanagementsystem.services.dtos.categoryDtos.requests;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
	@Pattern(regexp = "^[a-zA-Z0-9 ]{1,50}$", message = "Kategori sadece harf, rakam ve boşluk içerebilir.")
	private String categoryName;
}
