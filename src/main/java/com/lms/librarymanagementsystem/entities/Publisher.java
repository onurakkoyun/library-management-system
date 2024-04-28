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
@Table(name = "publishers")
public class Publisher extends BaseEntity<Integer> {
	
	@Column(name = "publisher_name")
	private String publisherName;

	@OneToMany(mappedBy = "publisher")
	private List<Book> books;
}
