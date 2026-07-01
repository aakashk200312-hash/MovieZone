package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.request.AddShowRequest;
import com.example.demo.controller.request.UpdateShowRequest;
import com.example.demo.controller.response.ShowResponse;
import com.example.demo.entity.Show;
import com.example.demo.service.ShowService;


@RestController
public class ShowController {
	
	@Autowired
	private ShowService showService;

	@PostMapping("/addShow")
	public ShowResponse addShow(
			@RequestBody AddShowRequest request) {
		
		return showService.addShow(request);
	}
	
	@GetMapping("/shows")
	public ShowResponse getAllShows() {
		
		return showService.getAllShows();
		
	}
	
	@GetMapping("/show/{id}")
	public Show getShow(@PathVariable int id){
	    return showService.getShow(id);
	}

	@PutMapping("/updateShow")
	public ShowResponse updateShow(@RequestBody UpdateShowRequest request){
	    return showService.updateShow(request);
	}

	@PatchMapping("/patchShow")
	public ShowResponse patchShow(@RequestBody UpdateShowRequest request){
	    return showService.patchShow(request);
	}

	@DeleteMapping("/deleteShow/{id}")
	public ShowResponse deleteShow(@PathVariable int id){
	    return showService.deleteShow(id);
	}
			
}
