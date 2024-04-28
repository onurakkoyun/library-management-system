package com.lms.librarymanagementsystem.services.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.services.abstracts.EmailService;

import jakarta.mail.internet.MimeMessage;
import lombok.Data;

@Data
@Service
public class EmailServiceServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String fromEmail;

	public EmailServiceServiceImpl(JavaMailSender javaMailSender,
			@Value("${spring.mail.username}") String fromEmail) {
		this.javaMailSender = javaMailSender;
		this.fromEmail = fromEmail;
	}

	@Override
	public void sendEmail(String to, String subject, String body) {

		try {
			MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // true for HTML content
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true); // true for HTML content
            javaMailSender.send(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
