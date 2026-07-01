package com.example.demo.controller.request;

import lombok.Data;

@Data
public class AddBookingRequest {
	
	private int movieId;
	private int userId;
	private int seats;
	
}
