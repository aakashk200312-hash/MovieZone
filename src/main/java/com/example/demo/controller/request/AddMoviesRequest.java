package com.example.demo.controller.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddMoviesRequest {
	
    
    private int id;
   
    private String name;
    
    private double rating;

    }
	
	
