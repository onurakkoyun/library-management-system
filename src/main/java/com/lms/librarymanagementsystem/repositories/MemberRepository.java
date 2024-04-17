package com.lms.librarymanagementsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lms.librarymanagementsystem.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
