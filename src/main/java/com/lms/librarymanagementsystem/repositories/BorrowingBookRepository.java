package com.lms.librarymanagementsystem.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.entities.BorrowingBook;

public interface BorrowingBookRepository extends JpaRepository<BorrowingBook, Integer>{
	
	Optional<BorrowingBook> findByBook_IdAndMember_Id(int bookId, int memberId);
}
