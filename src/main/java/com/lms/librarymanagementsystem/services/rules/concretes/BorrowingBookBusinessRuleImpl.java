package com.lms.librarymanagementsystem.services.rules.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.services.rules.abstracts.BorrowingBookBusinessRuleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BorrowingBookBusinessRuleImpl implements BorrowingBookBusinessRuleService {


	@Override
	public double calculatePenalty(LocalDate currentDate, LocalDate endDate) {

		if (currentDate.isAfter(endDate)) {
			long daysBetween = currentDate.toEpochDay() - endDate.toEpochDay();

			double penaltyAmount = daysBetween * 0.25; // Örnek olarak her geçen gün için 25 kuruş ceza.
			
			return penaltyAmount;
		}

		return 0;
	}

}
