package com.lms.librarymanagementsystem.services.abstracts;

public interface EmailService {
	void sendEmail(String to, String subject, String body);
}
