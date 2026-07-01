package com.example.demo.controller.response;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class GetMovieResponse {
	 
        @JsonProperty("movie_id")
	    private int id;
        
        @JsonProperty("movie_name")
	    private String name;
        
	    private double rating;
}
	    