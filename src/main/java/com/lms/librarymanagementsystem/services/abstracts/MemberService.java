package com.lms.librarymanagementsystem.services.abstracts;

import com.lms.librarymanagementsystem.entities.Member;
import com.lms.librarymanagementsystem.services.dtos.memberDtos.requests.AddMemberRequest;
import com.lms.librarymanagementsystem.services.dtos.memberDtos.responses.AddMemberResponse;

public interface MemberService {
	AddMemberResponse add(AddMemberRequest request);
	
	Member getById(int memberId);
}
