package com.example.demo.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddMovieResponse {
	
	@JsonProperty("response_message")
	private String message;
	
	 private String status;


}
