package com.lms.librarymanagementsystem.services.dtos.publisherDto.requests;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPublisherRequest {
	@Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞİÖÇ\\s]+$", message = "Yayınevi ismi sadece harf veya boşluk içerebilir.")
	private String publisherName;
}
