package com.example.demo.controller.request;

import lombok.Data;

@Data
public class UpdateBookingRequest {
	 private int bookingId;
	 private int movieId;
	 private int userId;
	 private int seats;
	 
	

}
