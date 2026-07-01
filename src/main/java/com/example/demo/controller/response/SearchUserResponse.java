package com.example.demo.controller.response;

import lombok.Data;

@Data
public class SearchUserResponse {
	
	private int userId;
	private String userName;
	private String email;
	private String mobileNumber;
	

}