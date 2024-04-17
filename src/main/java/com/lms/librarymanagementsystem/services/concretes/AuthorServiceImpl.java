package com.lms.librarymanagementsystem.services.concretes;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.entities.Author;
import com.lms.librarymanagementsystem.repositories.AuthorRepository;
import com.lms.librarymanagementsystem.services.abstracts.AuthorService;
import com.lms.librarymanagementsystem.services.dtos.authorDtos.requests.AddAuthorRequest;
import com.lms.librarymanagementsystem.services.dtos.authorDtos.responses.AddAuthorResponse;
import com.lms.librarymanagementsystem.services.mappers.AuthorMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

	private AuthorRepository authorRepository;

	@Override
	public AddAuthorResponse add(AddAuthorRequest request) {

		Author author = AuthorMapper.INSTANCE.mapAddAuthorRequestToAuthor(request);

		authorRepository.save(author);
		
		AddAuthorResponse response = new AddAuthorResponse("Author added.");

		return response;
	}

}
