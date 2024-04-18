package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.Member;
import com.lms.librarymanagementsystem.services.dtos.memberDtos.requests.AddMemberRequest;

@Mapper
public interface MemberMapper {
	MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

	Member mapAddMemberRequestToMember(AddMemberRequest request);
}
