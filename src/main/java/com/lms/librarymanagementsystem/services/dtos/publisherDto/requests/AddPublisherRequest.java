package com.lms.librarymanagementsystem.services.dtos.publisherDto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPublisherRequest {
	private String publisherName;
}
