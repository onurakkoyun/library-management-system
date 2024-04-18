package com.lms.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query("SELECT COUNT(borrowingBook) FROM BorrowingBook borrowingBook WHERE borrowingBook.book.id = :bookId AND "
			+ "isReturned = false")
	int getBorrowingCountByBookId(@Param("bookId") int bookId);
}
