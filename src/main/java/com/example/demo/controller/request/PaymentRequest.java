package com.example.demo.controller.request;

import lombok.Data;

@Data
public class PaymentRequest {
	
	private Long bookingId;
    private Double amount;
    private String paymentMethod;
}
