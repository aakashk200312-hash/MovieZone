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

import com.example.demo.controller.request.AddUserRequest;
import com.example.demo.controller.request.DeleteUserRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.controller.request.RegisterRequest;
import com.example.demo.controller.request.UpdateUserRequest;
import com.example.demo.controller.response.SearchUserResponse;
import com.example.demo.controller.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/addUser")
	public UserResponse addUser(
			@Valid @RequestBody AddUserRequest request) {
		
		return service.addUser(request);
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		
		return service.getUsers();
	}
	

    @GetMapping("/user/{id}")
    public User getUser(
            @PathVariable int id) {

        return service.getUser(id);
    }

    @PutMapping("/updateUser")
    public UserResponse updateUser(
            @RequestBody UpdateUserRequest request) {

        return service.updateUser(request);
    }

    @DeleteMapping("/deleteUser")
    public UserResponse deleteUser(
            @RequestBody DeleteUserRequest request) {

        return service.deleteUser(request);
    }

    @GetMapping("/searchUser/{id}")
    public SearchUserResponse searchUser(
            @PathVariable int id) {

        return service.searchUser(id);
    }
    
    @PatchMapping("/patchUser")
    public UserResponse patchUser(
    		@RequestBody UpdateUserRequest request) {
    	return service.patchUser(request);
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public UserResponse deleteUser(
    		@PathVariable int id) {
    	return service.deleteUser(id);
    }
    
    @PostMapping("/register")
    public UserResponse register(
    		@RequestBody RegisterRequest request) {
    	return service.register(request);
    }
    
    @PostMapping("/login")
    public UserResponse login(
    		@RequestBody LoginRequest request) {
    	
    	return service.login(request);
    }
   
}

