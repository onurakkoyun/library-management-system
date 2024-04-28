package com.lms.librarymanagementsystem.core.utilities.configurations;

import com.lms.librarymanagementsystem.core.utilities.configurations.TwilioConfig;
import org.springframework.beans.factory.annotation.Autowired;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class TwilioInitializer {

	@Autowired
	private TwilioConfig twilioConfig;

	public void sendSms(String to, String message) {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
		Message.creator(new PhoneNumber(to), new PhoneNumber(twilioConfig.getPhoneNumber()), message).create();
	}
}
