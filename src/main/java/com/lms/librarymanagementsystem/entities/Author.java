package com.lms.librarymanagementsystem.entities;

import java.time.LocalDate;
import java.util.List;

import com.lms.librarymanagementsystem.entities.baseEntity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
@Table(name = "authors")
public class Author extends BaseEntity<Integer>{
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "date_of_death")
	private LocalDate dateOfDeath;
	
	@Column(name = "about_author")
	private String aboutAuthor;
	
	@ManyToMany(mappedBy = "authors")
    private List<Book> books;
}
