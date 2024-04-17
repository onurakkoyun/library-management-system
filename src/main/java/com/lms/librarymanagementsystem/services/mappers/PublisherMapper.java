package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.Publisher;
import com.lms.librarymanagementsystem.services.dtos.publisherDto.requests.AddPublisherRequest;

@Mapper
public interface PublisherMapper {
	PublisherMapper INSTANCE =  Mappers.getMapper(PublisherMapper.class);
	
	Publisher mapAddPublisherRequestToPublisher(AddPublisherRequest request);
}
