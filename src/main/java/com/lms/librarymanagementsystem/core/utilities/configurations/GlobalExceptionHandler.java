package com.lms.librarymanagementsystem.core.utilities.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lms.librarymanagementsystem.core.utilities.exceptions.problemdetails.BusinessProblemDetails;
import com.lms.librarymanagementsystem.core.utilities.exceptions.problemdetails.ValidationProblemDetails;
import com.lms.librarymanagementsystem.core.utilities.exceptions.types.BusinessException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({ BusinessException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public BusinessProblemDetails handleBusinessException(BusinessException exception) {
		BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails(exception.getMessage());
		return businessProblemDetails;
	} // İş Kuralları

	@ExceptionHandler({ MethodArgumentNotValidException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception) {
		List<String> errorMessages = new ArrayList<>();
		List<FieldError> errors = exception.getBindingResult().getFieldErrors();
		for (FieldError error : errors) {
			errorMessages.add(error.getDefaultMessage());
		}
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails(errorMessages);
		return validationProblemDetails;
	}
}
