package com.lms.librarymanagementsystem.services.concretes;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
import com.lms.librarymanagementsystem.entities.Member;
import com.lms.librarymanagementsystem.repositories.MemberRepository;
import com.lms.librarymanagementsystem.services.abstracts.MemberService;
import com.lms.librarymanagementsystem.services.dtos.memberDtos.requests.AddMemberRequest;
import com.lms.librarymanagementsystem.services.dtos.memberDtos.responses.AddMemberResponse;
import com.lms.librarymanagementsystem.services.mappers.MemberMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	private MemberRepository memberRepository;

	@Override
	public AddMemberResponse add(AddMemberRequest request) {
		Member member = MemberMapper.INSTANCE.mapAddMemberRequestToMember(request);

		memberRepository.save(member);

		AddMemberResponse response = new AddMemberResponse("Member added.");

		return response;
	}

	@Override
	public Member getById(int memberId) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new BusinessException("Member is not found!"));
		return member;
	}

}
