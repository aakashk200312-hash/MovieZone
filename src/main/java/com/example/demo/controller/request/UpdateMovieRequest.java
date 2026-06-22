package com.example.demo.controller.request;

import lombok.Data;

@Data
public class UpdateMovieRequest {

    private int id;
    private String name;
    private double rating;

   
}