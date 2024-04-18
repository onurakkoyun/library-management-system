package com.lms.librarymanagementsystem.services.rules.abstracts;

import com.lms.librarymanagementsystem.entities.BorrowingBook;

public interface BookBusinessRuleService {
	void checkIfBookAvailableForBorrowing(BorrowingBook borrowingBook);
}
