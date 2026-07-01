package com.example.demo.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movie_show")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showId;
	
	@ManyToOne
    @JoinColumn(name="movie_id")
	@JsonBackReference("movie-show")
    private Movie movie;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate showDate;
	
	private String showTime;
	
	private int totalSeats;
	
	private int availableSeats;
	
	
	

}
