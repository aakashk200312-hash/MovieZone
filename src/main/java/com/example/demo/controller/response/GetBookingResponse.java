package com.example.demo.controller.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GetBookingResponse {
	
	private int bookingId;
	private int movieId;
	private String userName;
	private int seats;
	

}
