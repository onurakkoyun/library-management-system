package com.lms.librarymanagementsystem.services.dtos.bookDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignPublisherRequest {
	private int publisherId;
}
