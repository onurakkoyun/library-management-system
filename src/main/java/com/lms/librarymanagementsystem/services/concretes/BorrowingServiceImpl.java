package com.lms.librarymanagementsystem.services.concretes;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
import com.lms.librarymanagementsystem.entities.BorrowingBook;
import com.lms.librarymanagementsystem.entities.Member;
import com.lms.librarymanagementsystem.repositories.BorrowingBookRepository;
import com.lms.librarymanagementsystem.services.abstracts.BookService;
import com.lms.librarymanagementsystem.services.abstracts.BorrowingBookService;
import com.lms.librarymanagementsystem.services.abstracts.MemberService;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.AddBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.ReturnBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.AddBorrowingBookResponse;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.ReturnBorrowingBookResponse;
import com.lms.librarymanagementsystem.services.mappers.BorrowingBookMapper;
import com.lms.librarymanagementsystem.services.rules.abstracts.BookBusinessRuleService;
import com.lms.librarymanagementsystem.services.rules.abstracts.BorrowingBookBusinessRuleService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BorrowingServiceImpl implements BorrowingBookService {

	private BorrowingBookRepository borrowingBookRepository;

	private MemberService memberService;

	private BorrowingBookBusinessRuleService borrowingBookBusinessRuleService;

	private BookBusinessRuleService bookBusinessRuleService;
	
	private BookService bookService;

	@Override
	public AddBorrowingBookResponse add(AddBorrowingBookRequest request) {
		BorrowingBook borrowingBook = BorrowingBookMapper.INSTANCE.mapAddBorrowingBookRequestToBorrowingBook(request);

		bookBusinessRuleService.checkIfBookAvailableForBorrowing(borrowingBook);

		borrowingBook.setStartDate(LocalDate.now());
		borrowingBook.setReturned(false);

		bookService.increaseBorrowingInStock(request.getBookId());// Kitabın kiralanma sayısını arttırdık.
		borrowingBookRepository.save(borrowingBook);

		AddBorrowingBookResponse response = new AddBorrowingBookResponse("The book was lent.");

		return response;
	}

	@Override
	public ReturnBorrowingBookResponse returnBook(ReturnBorrowingBookRequest request) {
		Member member = memberService.getById(request.getMemberId());

		Optional<BorrowingBook> optionalBorrowingBook = Optional.ofNullable(borrowingBookRepository
				.findByBook_IdAndMember_Id(request.getBookId(), request.getMemberId()).orElseThrow(
						() -> new BusinessException("This member has not borrowed the book currently in question.")));

		BorrowingBook borrowingBook = optionalBorrowingBook.get();

		LocalDate currentDate = LocalDate.now();

		if (currentDate.isAfter(borrowingBook.getEndDate())) {
			double penaltyAmount = borrowingBookBusinessRuleService.calculatePenalty(currentDate,
					borrowingBook.getEndDate());
			member.setPenaltyAmount(member.getPenaltyAmount() + penaltyAmount);
		}

		bookService.decreaseBorrowingInStock(request.getBookId());// Kitabın kiralanma sayısını azalttık.
		borrowingBook.setReturnDate(currentDate);
		borrowingBook.setReturned(true);
		borrowingBookRepository.save(borrowingBook);

		return new ReturnBorrowingBookResponse(
				"The return process is successful." + " Member debt amount : " + member.getPenaltyAmount() + " TL");
	}

}
