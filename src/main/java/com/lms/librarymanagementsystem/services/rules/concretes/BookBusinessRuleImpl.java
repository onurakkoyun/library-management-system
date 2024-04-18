package com.lms.librarymanagementsystem.services.rules.concretes;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
import com.lms.librarymanagementsystem.entities.Book;
import com.lms.librarymanagementsystem.entities.BorrowingBook;
import com.lms.librarymanagementsystem.repositories.BookRepository;
import com.lms.librarymanagementsystem.services.rules.abstracts.BookBusinessRuleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookBusinessRuleImpl implements BookBusinessRuleService {

	private BookRepository bookRepository;

	@Override
	public void checkIfBookAvailableForBorrowing(BorrowingBook borrowingBook) {
		Optional<Book> optionalBook = bookRepository.findById(borrowingBook.getBook().getId());
		if (optionalBook.isPresent()) {
			Book book = optionalBook.get();
			int unitsInStock = book.getUnitsInStock();
			int borrowingCount = bookRepository.getBorrowingCountByBookId(book.getId());
			if (borrowingCount >= unitsInStock ) {
				throw new BusinessException("The requested book is not in stock.");
			}
		}
		else {
			throw new BusinessException("The requested book is not found!");
		}
	}
}
