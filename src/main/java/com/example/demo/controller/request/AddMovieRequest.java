package com.example.demo.controller.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddMovieRequest {
	
    
    private int id;
   
    private String name;
    
    private double rating;
    
    private double ticketPrice;

    }
	
	
