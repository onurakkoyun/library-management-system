package com.lms.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
