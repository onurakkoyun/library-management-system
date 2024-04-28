package com.lms.librarymanagementsystem.entities;


import java.util.List;

import com.lms.librarymanagementsystem.entities.baseEntity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
public class Member extends BaseEntity<Integer>{
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "identity_number", unique = true)
	private String identityNumber;

	@Column(name = "year_of_birth")
	private int yearOfBirth;

	@Column(name = "penalty_amount")
	private double penaltyAmount;
	
	@OneToMany(mappedBy = "member")
	private List<BorrowingBook> borrowingBooks;
}
