package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.publisherDto.requests.AddPublisherRequest;
import com.lms.librarymanagementsystem.services.dtos.publisherDto.responses.AddPublisherResponse;

public interface PublisherService {
	AddPublisherResponse add(AddPublisherRequest request);
}
