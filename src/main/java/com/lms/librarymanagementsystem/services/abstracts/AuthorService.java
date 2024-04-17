package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.services.dtos.authorDtos.requests.AddAuthorRequest;
import com.lms.librarymanagementsystem.services.dtos.authorDtos.responses.AddAuthorResponse;

public interface AuthorService {
	AddAuthorResponse add(AddAuthorRequest request);
}
