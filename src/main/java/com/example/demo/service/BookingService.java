package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.request.AddBookingRequest;
import com.example.demo.controller.request.DeleteBookingRequest;
import com.example.demo.controller.request.UpdateBookingRequest;
import com.example.demo.controller.response.ApiResponse;
import com.example.demo.controller.response.BookingResponse;
import com.example.demo.controller.response.DeleteBookingResponse;
import com.example.demo.controller.response.GetBookingResponse;
import com.example.demo.controller.response.SearchBookingResponse;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Movie;
import com.example.demo.entity.User;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.repository.UserRepository;

@Service
public class BookingService {
	
	@Autowired
    private  BookingRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired 
	private UserRepository userRepository;
	

    List<GetBookingResponse> bookingList =
            new ArrayList<>();
    
    
    public BookingService() {
    	
    	GetBookingResponse booking1=
    			new GetBookingResponse();
    	
    	booking1.setBookingId(1);
    	booking1.setMovieId(101);
    	booking1.setUserName("Aakash");
    	booking1.setSeats(2);
    	
    	GetBookingResponse booking2=
    			new GetBookingResponse();
    	
    	booking2.setBookingId(2);
    	booking2.setMovieId(102);
    	booking2.setUserName("Aman");
    	booking2.setSeats(4);
    	
    	GetBookingResponse booking3=
    			new GetBookingResponse();
    	
    	booking3.setBookingId(3);
    	booking3.setMovieId(103);
    	booking3.setUserName("Vishal");
    	booking3.setSeats(2);
    	
    	GetBookingResponse booking4=
    			new GetBookingResponse();
    	
    	booking4.setBookingId(4);
    	booking4.setMovieId(104);
    	booking4.setUserName("Naveen");
    	booking4.setSeats(2);
    	
    	GetBookingResponse booking5=
    			new GetBookingResponse();
    	
    	booking5.setBookingId(5);
    	booking5.setMovieId(105);
    	booking5.setUserName("Sahil");
    	booking5.setSeats(5);
    	
    	bookingList.add(booking1);
    	bookingList.add(booking2);
    	bookingList.add(booking3);
    	bookingList.add(booking4);
    	bookingList.add(booking5);
    	
    }
    public BookingResponse addBooking(AddBookingRequest request) {

        BookingResponse response = new BookingResponse();

        Movie movie = movieRepository.findById(request.getMovieId())
                .orElse(null);

        User user = userRepository.findById(request.getUserId())
                .orElse(null);

        if (movie == null || user == null) {
            response.setMessage("Movie or User Not Found");
            response.setStatus("Failed");
            return response;
        }

        Booking booking = new Booking();

        booking.setMovie(movie);
        booking.setUser(user);
        booking.setSeats(request.getSeats());

        repository.save(booking);

        response.setMessage("Booking Successful");
        response.setStatus("Success");

        return response;
    }

        public SearchBookingResponse searchBooking(
            int bookingId) {
    	
    	Booking booking = repository.findById(bookingId).orElse(null);
    	
    	if (booking == null) {
    		return null;
    	}

                SearchBookingResponse response =
                        new SearchBookingResponse();

                response.setBookingId(booking.getBookingId());

                response.setMovieId(booking.getMovie().getId());

                response.setUserId(booking.getUser().getUserId());

                response.setSeats(booking.getSeats());

                return response;
    }
    
        public ApiResponse updateBooking(UpdateBookingRequest request) {

            ApiResponse response =
                    new ApiResponse();

            Booking booking = repository.findById(request.getBookingId())
                    .orElse(null);

            if (booking == null) {
                response.setMessage("Booking Not Found");
                response.setStatus("Failed");
                return response;
            }

            Movie movie = movieRepository.findById(request.getMovieId())
                    .orElse(null);

            User user = userRepository.findById(request.getUserId())
                    .orElse(null);

            if (movie == null || user == null) {
                response.setMessage("Movie or User Not Found");
                response.setStatus("Failed");
                return response;
            }

            booking.setMovie(movie);
            booking.setUser(user);
            booking.setSeats(request.getSeats());

            repository.save(booking);

            response.setMessage("Booking Updated Successfully");
            response.setStatus("Success");

            return response;
        }

    public DeleteBookingResponse deleteBooking(
    		DeleteBookingRequest request) {
    	
    	DeleteBookingResponse response =
    			new DeleteBookingResponse();
    	
    	for(int i = 0; i < bookingList.size(); i++) {
    		
    		if(bookingList.get(i).getBookingId()
    				== request.getBookingId()) {
    			
    			bookingList.remove(i);
    			
    			response.setMessage("Booking Deleted");
    			
    			response.setStatus("Success");
    			
    			return response;
    		}
    	}
    	
    	response.setMessage("Booking Not Found");
    	
    	response.setStatus("Failed");
    	
    	return response;
    }
    		
    
    public List<Booking> getBookings(){

        return repository.findAll();
        
    }
    
    public DeleteBookingResponse deleteBooking(int id) {
    	
    	DeleteBookingResponse response = new DeleteBookingResponse();
    	
    	Booking booking = repository.findById(id).orElse(null);
    	
    	if(booking == null) {
    		response.setMessage("Booking Not Found");
    		response.setStatus("Failed");
    		return response;
    	}
    	
    	repository.delete(booking);
    	
    	response.setMessage("Booking Deleted Successfully");
    	response.setStatus("Success");
    	
    	return response;
    	
    }
}