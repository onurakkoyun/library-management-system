package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.Admin;
import com.lms.librarymanagementsystem.services.dtos.authDtos.requests.RegisterAdminRequest;

@Mapper
public interface AdminMapper {
	
	AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);
	
	Admin mapRegisterAdminRequestToAdmin(RegisterAdminRequest request);
}
