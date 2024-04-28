package com.lms.librarymanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.MemberService;
import com.lms.librarymanagementsystem.services.dtos.memberDtos.requests.AddMemberRequest;
import com.lms.librarymanagementsystem.services.dtos.memberDtos.responses.AddMemberResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MembersController {
	
	private MemberService memberService;
	
	@PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public AddMemberResponse add(@RequestBody @Valid AddMemberRequest request) {
        return memberService.add(request);
    }

}
