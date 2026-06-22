package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.controller.request.AddMoviesRequest;
import com.example.demo.controller.request.DeleteMovieRequest;
import com.example.demo.controller.request.UpdateMovieRequest;

import com.example.demo.controller.response.AddMovieResponse;
import com.example.demo.controller.response.GetMovieResponse;
import com.example.demo.controller.response.DeleteMovieResponse;
import com.example.demo.controller.response.SearchMovieResponse;
import com.example.demo.controller.response.UpdateMovieResponse;

import com.example.demo.service.MovieService;
import com.example.demo.entity.Movie;

@RestController
@RequestMapping()
public class MovieController {

    @Autowired
    private MovieService service;



    @PostMapping("/addMovie")
    public AddMovieResponse addMovie(
            @RequestBody AddMoviesRequest request) {

        return service.addMovie(request);
    }


    @GetMapping("/getMovies")
    public List<Movie> getMovies() {

        return service.getMovies();
    }



    @GetMapping("/getMovie/{id}")
    public Movie getMovie(
            @PathVariable int id) {

        return service.getMovie(id);
    }



    @PutMapping("/updateMovie")
    public UpdateMovieResponse updateMovie(
            @RequestBody UpdateMovieRequest request) {

        return service.updateMovie(request);
    }



    @DeleteMapping("/deleteMovie")
    public DeleteMovieResponse deleteMovie(
            @RequestBody DeleteMovieRequest request) {

        return service.deleteMovie(request);
    }
    

    @GetMapping("/searchMovie")
    public SearchMovieResponse searchMovie(
            @RequestParam String name) {

        return service.searchMovie(name);
    }
    
    @PatchMapping("/patchMovie")
    public UpdateMovieResponse patchMovie(
    		@RequestBody UpdateMovieRequest request) {
    	
    	return service.patchMovie(request);
    }
    
    @DeleteMapping("/deleteMocie/{id}")
    public DeleteMovieResponse deleteMovie(
    		@PathVariable int id) {
    	
    	return service.deleteMovie(id);
    }
}