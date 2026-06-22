package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private int userId;
	
	private String userName;
	
	private String email;
	
	private String mobileNumber;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Booking> bookings;
	

}
