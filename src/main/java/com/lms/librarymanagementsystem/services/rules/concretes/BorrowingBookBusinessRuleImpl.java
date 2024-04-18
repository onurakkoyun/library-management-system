package com.lms.librarymanagementsystem.services.rules.concretes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.services.rules.abstracts.BorrowingBookBusinessRuleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BorrowingBookBusinessRuleImpl implements BorrowingBookBusinessRuleService {

	@Override
	public double calculatePenalty(LocalDate currentDate, LocalDate endDate) {
		
		long daysBetween = ChronoUnit.DAYS.between(currentDate, endDate);
		
		/*int currentYear = currentDate.getYear();
	    int currentMonth = currentDate.getMonthValue();
	    int currentDay = currentDate.getDayOfMonth();

	    int endYear = endDate.getYear();
	    int endMonth = endDate.getMonthValue();
	    int endDay = endDate.getDayOfMonth();

	    int yearDiff = currentYear - endYear;
	    int monthDiff = currentMonth - endMonth;
	    int dayDiff = currentDay - endDay;

	    int totalDays = (yearDiff * 365) + (monthDiff * 30) + dayDiff;*/
	    return daysBetween * 0.25; // Örnek olarak her geçen gün için 25 kuruş ceza.
	}
}
