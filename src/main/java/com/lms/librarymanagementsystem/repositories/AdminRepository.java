package com.lms.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
}
