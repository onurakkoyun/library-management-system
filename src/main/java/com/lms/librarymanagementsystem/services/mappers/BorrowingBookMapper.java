package com.lms.librarymanagementsystem.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.lms.librarymanagementsystem.entities.BorrowingBook;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.AddBorrowingBookRequest;

@Mapper
public interface BorrowingBookMapper {
	BorrowingBookMapper INSTANCE =  Mappers.getMapper(BorrowingBookMapper.class);
	
	@Mapping(target = "book.id", source = "bookId")
	@Mapping(target = "member.id", source = "memberId")
	BorrowingBook mapAddBorrowingBookRequestToBorrowingBook(AddBorrowingBookRequest request);
}
