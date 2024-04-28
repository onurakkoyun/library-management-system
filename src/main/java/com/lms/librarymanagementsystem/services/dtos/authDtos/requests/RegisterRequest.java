package com.lms.librarymanagementsystem.services.dtos.authDtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	
	private String firstName;
    private String lastName;
    private String email;
    
    @NotBlank(message = "Password field is required")
    private String password;
    
    @NotBlank(message = "Confirm password field is required")
    private String passwordConfirm;

}
