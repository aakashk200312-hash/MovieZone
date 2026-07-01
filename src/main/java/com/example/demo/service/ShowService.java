package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.request.AddShowRequest;
import com.example.demo.controller.request.UpdateShowRequest;
import com.example.demo.controller.response.ShowResponse;
import com.example.demo.entity.Movie;
import com.example.demo.entity.Show;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository showRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
      public ShowResponse addShow(AddShowRequest request) {
    	  
        ShowResponse response = new ShowResponse();
		
		Movie movie = movieRepository.findById(request.getMovieId()).orElse(null);

		if (movie == null) {
		    response.setMessage("Movie Not Found");
		    response.setStatus("Failed");
		    return response;
		}

		
		Show show = new Show();
		
		show.setMovie(movie);
		
		show.setShowDate(request.getShowDate());
		
		show.setShowTime(request.getShowTime());
		
		show.setTotalSeats(request.getTotalSeats());
		
		show.setAvailableSeats(request.getTotalSeats());
		
		showRepository.save(show);
		

		response.setMessage("Show Added Successfully");
		
		response.setStatus("Success");
		
		return response;
		
	}
      public ShowResponse getAllShows() {

    	    ShowResponse response = new ShowResponse();

    	    response.setStatus("Success");
    	    response.setMessage("Shows Found");
    	    response.setShows(showRepository.findAll());

    	    return response;
    	}
      
      public Show getShow(int id){
    	    return showRepository.findById(id).orElse(null);
    	}
      
      public ShowResponse updateShow(UpdateShowRequest request){

    	    ShowResponse response = new ShowResponse();

    	    Show show = showRepository.findById(request.getShowId()).orElse(null);

    	    if(show == null){
    	        response.setMessage("Show Not Found");
    	        response.setStatus("Failed");
    	        return response;
    	    }

    	    Movie movie = movieRepository.findById(request.getMovieId()).orElse(null);

    	    if(movie == null){
    	        response.setMessage("Movie Not Found");
    	        response.setStatus("Failed");
    	        return response;
    	    }

    	    show.setMovie(movie);
    	    show.setShowDate(request.getShowDate());
    	    show.setShowTime(request.getShowTime());
    	    show.setTotalSeats(request.getTotalSeats());
    	    show.setAvailableSeats(request.getAvailableSeats());

    	    showRepository.save(show);

    	    response.setMessage("Show Updated Successfully");
    	    response.setStatus("Success");

    	    return response;
    	}
      
      public ShowResponse patchShow(UpdateShowRequest request){

    	    ShowResponse response = new ShowResponse();

    	    Show show = showRepository.findById(request.getShowId()).orElse(null);

    	    if(show == null){
    	        response.setMessage("Show Not Found");
    	        response.setStatus("Failed");
    	        return response;
    	    }

    	    if(request.getShowDate()!=null)
    	        show.setShowDate(request.getShowDate());

    	    if(request.getShowTime()!=null)
    	        show.setShowTime(request.getShowTime());

    	    if(request.getTotalSeats()!=0)
    	        show.setTotalSeats(request.getTotalSeats());

    	    if(request.getAvailableSeats()!=0)
    	        show.setAvailableSeats(request.getAvailableSeats());

    	    showRepository.save(show);

    	    response.setMessage("Show Updated Successfully");
    	    response.setStatus("Success");

    	    return response;
    	}
      
      public ShowResponse deleteShow(int id){

    	    ShowResponse response = new ShowResponse();

    	    Show show = showRepository.findById(id).orElse(null);

    	    if(show == null){
    	        response.setMessage("Show Not Found");
    	        response.setStatus("Failed");
    	        return response;
    	    }

    	    showRepository.delete(show);

    	    response.setMessage("Show Deleted Successfully");
    	    response.setStatus("Success");

    	    return response;
    	}
      
}
