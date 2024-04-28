package com.lms.librarymanagementsystem.services.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.core.utilities.configurations.TwilioInitializer;
import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;
import com.lms.librarymanagementsystem.entities.BorrowingBook;
import com.lms.librarymanagementsystem.entities.Member;
import com.lms.librarymanagementsystem.repositories.BorrowingBookRepository;
import com.lms.librarymanagementsystem.services.abstracts.BookService;
import com.lms.librarymanagementsystem.services.abstracts.BorrowingBookService;
import com.lms.librarymanagementsystem.services.abstracts.EmailService;
import com.lms.librarymanagementsystem.services.abstracts.MemberService;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.AddBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.requests.ReturnBorrowingBookRequest;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.AddBorrowingBookResponse;
import com.lms.librarymanagementsystem.services.dtos.borrowingBookDtos.responses.ReturnBorrowingBookResponse;
import com.lms.librarymanagementsystem.services.mappers.BorrowingBookMapper;
import com.lms.librarymanagementsystem.services.rules.abstracts.BookBusinessRuleService;
import com.lms.librarymanagementsystem.services.rules.abstracts.BorrowingBookBusinessRuleService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BorrowingServiceImpl implements BorrowingBookService {

	private BorrowingBookRepository borrowingBookRepository;

	private MemberService memberService;

	private BorrowingBookBusinessRuleService borrowingBookBusinessRuleService;

	private BookBusinessRuleService bookBusinessRuleService;

	private BookService bookService;

	private TwilioInitializer twilioInitializer;
	
	private EmailService emailService;

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

		bookService.decreaseBorrowingInStock(request.getBookId());// Kitabın kiralanma sayısını azalttık.

		BorrowingBook borrowingBook = optionalBorrowingBook.get();

		LocalDate currentDate = LocalDate.now();

		double checkPenalty = borrowingBookBusinessRuleService.calculatePenalty(currentDate,
				borrowingBook.getEndDate());

		member.setPenaltyAmount(member.getPenaltyAmount() + checkPenalty);

		borrowingBook.setReturnDate(currentDate);
		borrowingBook.setReturned(true);

		borrowingBookRepository.save(borrowingBook);

		return new ReturnBorrowingBookResponse(
				"The return process is successful." + " Member debt amount : " + member.getPenaltyAmount() + " TL");
	}

	@Transactional
	@Override
	public void sendReminderForDueBooks() {
		LocalDate today = LocalDate.now();
		LocalDate dueDate = today.plusDays(1);

		List<BorrowingBook> dueBorrowingBooks = borrowingBookRepository.findByEndDate(dueDate);

		for (BorrowingBook borrowingBook : dueBorrowingBooks) {
			String message = "Merhaba " + borrowingBook.getMember().getFirstName()+ ",<br/>Kütüphanemizden almış olduğunuz <strong>" 
				    + borrowingBook.getBook().getBookName() + "</strong> kitabın son teslim tarihi yarın.<br/>Lütfen ödünç almış olduğunuz kitabı zamanında teslim ediniz. "
				    + "Teslim tarihi geçen her gün tarafınıza <strong>0,25 kuruş</strong> ceza yansıtılacaktır bilginize."
				    + "<br/><br/>- Kütüphane Yönetimi";

			//twilioInitializer.sendSms(borrowingBook.getMember().getPhoneNumber(), message);
			
			emailService.sendEmail(borrowingBook.getMember().getEmail(), "Kitap İade Bildirimi", message);
			
		}
	}

}
