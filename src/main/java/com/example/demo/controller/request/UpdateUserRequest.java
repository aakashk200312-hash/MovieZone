package com.example.demo.controller.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
	
	private int userId;
	private String userName;
	private String email;
	private String mobileNumber;
	

}
