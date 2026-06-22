package com.example.demo.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeleteBookingResponse {
	
	@JsonProperty("response_message")
	private String message;
	
	private String status;

}
