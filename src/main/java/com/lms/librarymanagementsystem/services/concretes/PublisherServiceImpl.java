package com.lms.librarymanagementsystem.services.concretes;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.entities.Publisher;
import com.lms.librarymanagementsystem.repositories.PublisherRepository;
import com.lms.librarymanagementsystem.services.abstracts.PublisherService;
import com.lms.librarymanagementsystem.services.dtos.publisherDto.requests.AddPublisherRequest;
import com.lms.librarymanagementsystem.services.dtos.publisherDto.responses.AddPublisherResponse;
import com.lms.librarymanagementsystem.services.mappers.PublisherMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PublisherServiceImpl implements PublisherService{
	private PublisherRepository publisherRepository;
	
	@Override
	public AddPublisherResponse add(AddPublisherRequest request) {
		
		Publisher publisher = PublisherMapper.INSTANCE.mapAddPublisherRequestToPublisher(request);
		
		publisherRepository.save(publisher);
		
		AddPublisherResponse response = new AddPublisherResponse("Publisher added.");
		
		return response;
	}

}
