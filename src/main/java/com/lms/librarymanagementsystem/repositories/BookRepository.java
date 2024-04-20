package com.lms.librarymanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lms.librarymanagementsystem.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("SELECT bk FROM Book bk INNER JOIN bk.authors ba " +
            "WHERE LOWER(bk.bookName) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "OR LOWER(bk.bookName) LIKE LOWER(CONCAT('%', REPLACE(:searchText, ' ', '%'), '%')) " +
            "OR LOWER(bk.bookName) LIKE LOWER(CONCAT('%', REPLACE(:searchText, '', '%'), '%')) " +
            "OR LOWER(ba.firstName) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "OR LOWER(ba.lastName) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "OR LOWER(CONCAT(ba.firstName, ' ', ba.lastName)) LIKE LOWER(CONCAT('%', :searchText, '%')) " +
            "OR LOWER(CONCAT(ba.firstName , ba.lastName)) LIKE LOWER(CONCAT('%', :searchText, '%'))")
    List<Book> searchBooks(@Param("searchText") String searchText);
}
