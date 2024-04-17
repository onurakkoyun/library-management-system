package com.lms.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
}
