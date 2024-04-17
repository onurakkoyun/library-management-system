package com.lms.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.entities.BorrowingBook;

public interface BorrowingBookRepository extends JpaRepository<BorrowingBook, Integer>{

}
