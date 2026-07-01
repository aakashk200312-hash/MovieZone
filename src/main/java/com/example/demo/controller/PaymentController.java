package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.request.PaymentRequest;
import com.example.demo.controller.response.PaymentResponse;
import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;


@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/makePayment")
	public PaymentResponse makePayment(
			@RequestBody PaymentRequest request) {
		
		return paymentService.makePayment(request);
	}
	
	@GetMapping("/getPayments")
	public List<Payment> getPayments(){
	    return paymentService.getPayments();
	}

	@GetMapping("/payment/{id}")
	public Payment getPayment(@PathVariable Long id){
	    return paymentService.getPayment(id);
	}
	

}
