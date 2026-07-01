package com.example.demo.controller.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UpdateShowRequest {
	
	private int showId;

    private int movieId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate showDate;

    private String showTime;

    private int totalSeats;

    private int availableSeats;
	

}
