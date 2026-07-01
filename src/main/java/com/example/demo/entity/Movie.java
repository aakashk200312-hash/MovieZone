package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Movie {
	
	@Id
	private int id;
	
	private String name;
	
	private double rating;
	
	private double ticketPrice;
	
	@OneToMany(mappedBy = "movie")
	@JsonManagedReference("movie-show")
	private List<Booking> bookings;
	
	@OneToMany(mappedBy = "movie")
	@JsonManagedReference("movie-booking")
	private List<Show> shows;

}
