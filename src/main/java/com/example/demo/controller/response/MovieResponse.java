package com.example.demo.controller.response;

import java.util.List;

import com.example.demo.entity.Movie;

import lombok.Data;

@Data
public class MovieResponse {
	
	private String message;
	
	private String status;
	
	private Movie movie;
	
	private List<Movie> movies;

}
