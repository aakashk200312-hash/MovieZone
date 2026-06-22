package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Booking {
	@Id
	private int bookingId;
	
	
	private int seats;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	@JsonBackReference
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

}
