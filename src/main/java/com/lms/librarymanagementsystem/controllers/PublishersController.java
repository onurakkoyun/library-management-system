package com.lms.librarymanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.PublisherService;
import com.lms.librarymanagementsystem.services.dtos.publisherDto.requests.AddPublisherRequest;
import com.lms.librarymanagementsystem.services.dtos.publisherDto.responses.AddPublisherResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/publishers")
public class PublishersController {
	
	private PublisherService publisherService;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddPublisherResponse add(@RequestBody @Valid AddPublisherRequest request) {
        return publisherService.add(request);
    }

}
