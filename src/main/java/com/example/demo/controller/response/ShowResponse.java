package com.example.demo.controller.response;

import java.util.List;

import com.example.demo.entity.Show;

import lombok.Data;

@Data
public class ShowResponse {
	
	private String message;
	
	private String status;
	
	private String showDate;
	
	
	private List<Show> shows;

}
