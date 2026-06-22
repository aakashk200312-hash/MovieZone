package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.request.AddBookingRequest;
import com.example.demo.controller.request.DeleteBookingRequest;
import com.example.demo.controller.request.UpdateBookingRequest;
import com.example.demo.controller.response.BookingResponse;
import com.example.demo.controller.response.DeleteBookingResponse;
import com.example.demo.controller.response.GetBookingResponse;
import com.example.demo.controller.response.SearchBookingResponse;
import com.example.demo.controller.response.UpdateBookingResponse;
import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
public class BookingController {

    @Autowired
    BookingService service;

    @PostMapping("/addBooking")
    public BookingResponse addBooking(
            @RequestBody AddBookingRequest request) {

        return service.addBooking(request);
    }

    @GetMapping("/getBookings")
    public List<Booking> getBookings() {

        return service.getBookings();
    }
    
    @GetMapping("/searchBooking/{bookingId}")
    public SearchBookingResponse searchBooking(
    		@PathVariable int bookingId) {
    	
    	return service.searchBooking(
    			bookingId);
    }
    
    @PutMapping("/updateBooking")
    public UpdateBookingResponse updateBooking(
    		@RequestBody 
    		UpdateBookingRequest request) {
    	
    	return service.updateBooking(request);
    }
    
    @PatchMapping("/patchBooking")
    public UpdateBookingResponse patchBooking(
            @RequestBody
            UpdateBookingRequest request){

        return service.updateBooking(
                request);
        
    }
    
    @DeleteMapping("/deleteBooking")
    public DeleteBookingResponse deleteBooking(
    @RequestBody  DeleteBookingRequest request) {
    	
    	return service.deleteBooking(request);
    }
   
    @DeleteMapping("/deleteBooking/{id}")
    public DeleteBookingResponse deleteBooking(
    		@PathVariable int id) {
    	
    	return service.deleteBooking(id);
    }
    
    
    
}