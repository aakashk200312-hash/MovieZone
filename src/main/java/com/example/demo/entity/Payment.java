package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	private Double Amount;
	
	private String paymentMethod;
	
	private String paymentStatus;
	
	private LocalDateTime paymentDate;
	
	
	

}
