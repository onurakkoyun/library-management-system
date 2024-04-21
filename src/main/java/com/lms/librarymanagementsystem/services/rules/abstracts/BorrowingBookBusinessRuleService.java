package com.lms.librarymanagementsystem.services.rules.abstracts;

import java.time.LocalDate;

public interface BorrowingBookBusinessRuleService {	
	double calculatePenalty(LocalDate currentDate, LocalDate endDate);
}
