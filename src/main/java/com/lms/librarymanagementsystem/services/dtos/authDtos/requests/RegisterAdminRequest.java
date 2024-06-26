package com.lms.librarymanagementsystem.services.dtos.authDtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAdminRequest {
	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String passwordConfirm;
}
