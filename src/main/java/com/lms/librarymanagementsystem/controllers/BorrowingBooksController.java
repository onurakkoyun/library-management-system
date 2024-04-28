package com.lms.librarymanagementsystem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lms.librarymanagementsystem.services.abstracts.BorrowingBookService;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.AddBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.ReturnBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.AddBorrowingBookResponse;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.ReturnBorrowingBookResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/borrowingBooks")
public class BorrowingBooksController {

	private BorrowingBookService borrowingBookService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public AddBorrowingBookResponse add(@RequestBody @Valid AddBorrowingBookRequest request) {
		return borrowingBookService.add(request);
	}

	@PutMapping("/returnBook")
	@ResponseStatus(HttpStatus.OK)
	public ReturnBorrowingBookResponse returnBook(@RequestBody @Valid ReturnBorrowingBookRequest request) {
		return borrowingBookService.returnBook(request);
	}

	@Scheduled(cron = "0 07 13 * * *")//Her gün sabah saat 10'da bu fonksiyon çalışacak.
	@GetMapping("/send-reminders")
	public void sendRemindersForDueBooks() {
		borrowingBookService.sendReminderForDueBooks();
	}
}
