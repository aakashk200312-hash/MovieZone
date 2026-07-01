package com.example.demo.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddUserRequest {
	
	private String userName;
	
	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Invalid Email Format")
	private String email;
	
	private String password;
	
	
	private String mobileNumber;

}
