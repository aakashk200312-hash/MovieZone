package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepository 
extends JpaRepository<User, Integer>{
	
	User findByUserName(String userName);
	
	boolean existsByEmail(String email);
	
	User findByEmail(String email);
	

}
