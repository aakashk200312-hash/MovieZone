package com.example.demo.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DeleteBookingRequest {

	@JsonProperty("booking_id")
	private int bookingId;

}