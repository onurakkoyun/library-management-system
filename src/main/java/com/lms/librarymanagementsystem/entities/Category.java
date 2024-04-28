package com.lms.librarymanagementsystem.entities;

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
@Table(name = "categories")
public class Category extends BaseEntity<Integer>{
	
	@Column(name = "category_name")
	private String categoryName;
	
	@ManyToMany(mappedBy = "categories")
    private List<Book> books;
}
