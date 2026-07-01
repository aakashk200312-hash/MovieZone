package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.controller.request.AddMovieRequest;
import com.example.demo.controller.request.DeleteMovieRequest;
import com.example.demo.controller.request.UpdateMovieRequest;
import com.example.demo.controller.response.ApiResponse;
import com.example.demo.controller.response.GetMovieResponse;
import com.example.demo.controller.response.MovieResponse;
import com.example.demo.controller.response.SearchMovieResponse;
import com.example.demo.entity.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository repository;

    List<GetMovieResponse> movieList =
            new ArrayList<>();


    public MovieService() {

        GetMovieResponse movie1 =
                new GetMovieResponse();
        movie1.setId(101);
        movie1.setName("KGF");
        movie1.setRating(9.5);

        GetMovieResponse movie2 =
                new GetMovieResponse();
        movie2.setId(102);
        movie2.setName("Bahubali");
        movie2.setRating(9.2);


        GetMovieResponse movie3 =
                new GetMovieResponse();
        movie3.setId(103);
        movie3.setName("Pushpa");
        movie3.setRating(8.7);


        GetMovieResponse movie4 =
                new GetMovieResponse();
        movie4.setId(104);
        movie4.setName("Avengers");
        movie4.setRating(9.1);


        GetMovieResponse movie5 =
                new GetMovieResponse();
        movie5.setId(105);
        movie5.setName("Interstellar");
        movie5.setRating(9.8);
        GetMovieResponse movie6 =
                new GetMovieResponse();
        movie6.setId(106);
        movie6.setName("RRR");
        movie6.setRating(9.3);

        GetMovieResponse movie7 =
                new GetMovieResponse();
        movie7.setId(107);
        movie7.setName("John Wick");
        movie7.setRating(8.9);

        GetMovieResponse movie8 =
                new GetMovieResponse();
        movie8.setId(108);
        movie8.setName("Deadpool");
        movie8.setRating(8.7);

        GetMovieResponse movie9 =
                new GetMovieResponse();
        movie9.setId(109);
        movie9.setName("Black Panther");
        movie9.setRating(8.8);

        GetMovieResponse movie10 =
                new GetMovieResponse();
        movie10.setId(110);
        movie10.setName("Shershaah");
        movie10.setRating(8.9);
        
        
        

        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        movieList.add(movie4);
        movieList.add(movie5);
        movieList.add(movie6);
        movieList.add(movie7);
        movieList.add(movie8);
        movieList.add(movie9);
        movieList.add(movie10);
    }
    
   
        public ApiResponse addMovie(
                AddMovieRequest request){

            Movie movie = new Movie();

            movie.setId(request.getId());
            movie.setName(request.getName());
            movie.setRating(request.getRating());
            movie.setTicketPrice(request.getTicketPrice());

            repository.save(movie);

            ApiResponse response =
                    new ApiResponse();

            response.setMessage(
                    "Movie Added");

            response.setStatus(
                    "Success");

            return response;
        }

        public List<Movie> getMovies(){

            return repository.findAll();
        }
        
        public Movie getMovie(int id) {
        	return repository.findById(id)
        			.orElse(null);
        }
    

   
    public ApiResponse updateMovie(
            UpdateMovieRequest request) {

        ApiResponse response =
                new ApiResponse();

        Movie movie = repository.findById(request.getId()).orElse(null);
        

       if(movie == null){
       response.setMessage("Movie Not Found");
       response.setStatus("Failed");
       return response;
           }
        
            if(movie.getId() == request.getId()) {

                movie.setName(request.getName());
                movie.setRating(request.getRating());
                
                repository.save(movie);

                response.setMessage(
                        "Movie Updated Successfully");

                response.setStatus("Success");

                return response;
            }
            return response;
        }

    
    public ApiResponse deleteMovie(
            DeleteMovieRequest request) {

        ApiResponse response =
                new ApiResponse();
        Movie movie = repository.findById(request.getId()).orElse(null);

        if(movie == null){
            response.setMessage("Movie Not Found");
            response.setStatus("Failed");
            return response;
        }

        repository.delete(movie);

        response.setMessage("Movie Deleted Successfully");
        response.setStatus("Success");

        return response;

        
            }
   
    public SearchMovieResponse searchMovie(
            String name) {
    	
    	Movie movie = repository.findByNameIgnoreCase(name);
    	
    	if(movie == null) {
    		return null;
    	}

        SearchMovieResponse response =
                new SearchMovieResponse();


                response.setId(movie.getId());
                response.setName(movie.getName());
                response.setRating(movie.getRating());

                return response;
          
    }
    
    public ApiResponse patchMovie(
            UpdateMovieRequest request){

        ApiResponse response =
                new ApiResponse();

        Movie movie = repository.findById(
                request.getId()).orElse(null);

        if(movie == null){
            response.setMessage("Movie Not Found");
            response.setStatus("Failed");
            return response;
        }

        if(request.getName() != null){
            movie.setName(request.getName());
        }

        if(request.getRating() != 0){
            movie.setRating(request.getRating());
        }

        repository.save(movie);

        response.setMessage("Movie Updated Successfully");
        response.setStatus("Success");

        return response;
    }
    
    public ApiResponse deleteMovie(int id) {
    	
    	ApiResponse response = new ApiResponse();
    	
    	Movie movie = repository.findById(id).orElse(null);
    	
    	if(movie == null) {
    		
    		response.setMessage("Movie Not Found");
    		response.setStatus("Failed");
    		return response;
   
    	}
    	repository.delete(movie);
    	
    	response.setMessage("Movie Deleted Successfully");
    	response.setStatus("Success");
    	
    	return response;
    	
    }
    
}