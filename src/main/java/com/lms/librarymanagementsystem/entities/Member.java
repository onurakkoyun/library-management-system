package com.lms.librarymanagementsystem.entities;


import java.util.List;

import com.lms.librarymanagementsystem.core.utilities.entities.BaseEntity;

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
	
	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "identity_number", unique = true)
	private String identityNumber;

	@Column(name = "year_of_birth")
	private int yearOfBirth;

	@Column(name = "penalty_amount")
	private double penaltyAmount;
	
	@OneToMany(mappedBy = "member")
	private List<BorrowingBook> borrowingBooks;
}
