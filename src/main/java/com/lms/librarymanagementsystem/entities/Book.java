package com.lms.librarymanagementsystem.entities;

import java.time.LocalDate;
import java.util.List;

import com.lms.librarymanagementsystem.entities.baseEntity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "books")
public class Book extends BaseEntity<Integer> {
	
	@Column(name = "book_name")
	private String bookName;

	@Column(name = "isbn")
	private String isbn;

	@Column(name = "edition")
	private int edition;

	@Column(name = "number_of_pages")
	private int numberOfPages;

	@Column(name = "units_in_stock")
	private int unitsInStock;

	@Column(name = "borrowed_in_stock")
	private int borrowedInStock;

	@Column(name = "release_date")
	private LocalDate releaseDate;

	@OneToMany(mappedBy = "book")
	private List<BorrowingBook> borrowingBooks;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;

	@ManyToMany
	@JoinTable(name = "book_category", 
	joinColumns = @JoinColumn(name = "book_id"), 
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> categories;

	@ManyToMany
	@JoinTable(name = "book_author", 
	joinColumns = @JoinColumn(name = "book_id"), 
	inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;
}
