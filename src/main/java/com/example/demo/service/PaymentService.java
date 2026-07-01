package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.request.PaymentRequest;
import com.example.demo.controller.response.PaymentResponse;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Payment;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public PaymentResponse makePayment(PaymentRequest request) {
		
		PaymentResponse response = new PaymentResponse();
		
		Booking booking = bookingRepository.findById(request.getBookingId().intValue()).orElse(null);
	
	
	if(booking == null) {
		response.setMessage("Booking Not Found");
		
		response.setStatus("Failed");
		
		return response;
		
		
	}
	
	Payment payment = new Payment();
	
	payment.setBooking(booking);

    payment.setAmount(request.getAmount());

    payment.setPaymentMethod(request.getPaymentMethod());

    payment.setPaymentDate(LocalDateTime.now());

    payment.setPaymentStatus(
            "SUCCESS");

    paymentRepository.save(payment);

    response.setMessage(
            "Payment Successful");

    response.setStatus(
            "Success");

    return response;
		
		
	
	}
	
	public List<Payment> getPayments(){
	    return paymentRepository.findAll();
	}
	
	
	public Payment getPayment(Long id){
	    return paymentRepository.findById(id).orElse(null);
	}
	
	

}
