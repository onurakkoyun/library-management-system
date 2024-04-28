package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.baseEntity.User;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.RegisterAdminRequest;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE =  Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "roles", ignore = true)
	User mapRegisterAdminRequestToAdmin(RegisterAdminRequest request);
}
