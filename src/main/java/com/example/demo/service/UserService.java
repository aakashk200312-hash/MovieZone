package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.request.AddUserRequest;
import com.example.demo.controller.request.DeleteUserRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.controller.request.RegisterRequest;
import com.example.demo.controller.request.UpdateUserRequest;
import com.example.demo.controller.response.SearchUserResponse;
import com.example.demo.controller.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public UserResponse addUser(AddUserRequest request) {

	    UserResponse response = new UserResponse();

	    if (repository.existsByEmail(request.getEmail())) {
	        response.setMessage("Email already exists");
	        response.setStatus("Failed");
	        return response;
	    }
		
		User user = new User();
		
		user.setUserId(request.getUserId());
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setMobileNumber(request.getMobileNumber());
		
		repository.save(user);
		
		response.setMessage("User Added Successfully");
		response.setStatus("Success");
		
		return response;
		
		
	}
	
	public List<User> getUsers(){
		 return repository.findAll();
	}
	
	public User getUser(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public UserResponse updateUser(UpdateUserRequest request) {
		
		UserResponse response = new UserResponse();
		
		User user = repository.findById(
				request.getUserId()).orElse(null);
		
		if(user == null) {
			
			response.setMessage("User Not Found");
		    response.setStatus("Failed");
		    
		    return response;
		}
		
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setMobileNumber(request.getMobileNumber());

        repository.save(user);

        response.setMessage("User Updated Successfully");
        response.setStatus("Success");

        return response;
    }
	
	
	public UserResponse deleteUser(
            DeleteUserRequest request) {

        UserResponse response = new UserResponse();

        User user = repository.findById(
                request.getUserId()).orElse(null);

        if(user == null) {

            response.setMessage("User Not Found");
            response.setStatus("Failed");

            return response;
        }
        
        repository.delete(user);

        response.setMessage("User Deleted Successfully");
        response.setStatus("Success");

        return response;
    }
	
	 public SearchUserResponse searchUser(
	            int userId) {

	        User user =
	                repository.findById(userId)
	                        .orElse(null);

	        if(user == null) {
	            return null;
	        }

	        SearchUserResponse response =
	                new SearchUserResponse();

	        response.setUserId(user.getUserId());
	        response.setUserName(user.getUserName());
	        response.setEmail(user.getEmail());
	        response.setMobileNumber(user.getMobileNumber());

	        return response;
	    }
	 
	 public UserResponse deleteUser(int id) {
		 
		 UserResponse response = new UserResponse();
		 
		 User user = repository.findById(id)
				 .orElse(null);
		 
		 if(user == null) {
			 response.setMessage("User Not Found");
			 response.setStatus("Failed");
			 return response;
		 }
		 
		 repository.delete(user);
		 
		 response.setMessage("User Deleted Successfully");
		 response.setStatus("Success");
		 
		 return response;
		 
	 }
	 
	 public UserResponse patchUser(
		        UpdateUserRequest request){

		    UserResponse response =
		            new UserResponse();

		    User user =
		            repository.findById(
		                    request.getUserId())
		                    .orElse(null);

		    if(user == null){

		        response.setMessage("User Not Found");
		        response.setStatus("Failed");

		        return response;
		    }

		    if(request.getUserName() != null){
		        user.setUserName(request.getUserName());
		    }

		    if(request.getEmail() != null){
		        user.setEmail(request.getEmail());
		    }

		    if(request.getMobileNumber() != null){
		        user.setMobileNumber(request.getMobileNumber());
		    }

		    repository.save(user);

		    response.setMessage("User Updated Successfully");
		    response.setStatus("Success");

		    return response;
		}
	 
	 public UserResponse register(RegisterRequest request) {
		 
		 UserResponse response = new UserResponse();
		 
		 if(repository.existsByEmail(request.getEmail())) {
			 
			 response.setMessage("Email already exists");
			 response.setStatus("Failed");
			 
			 return response;
		 }
		 
		 User user = new User();
		 
		 user.setUserName(request.getUserName());
		 user.setEmail(request.getEmail());
		 user.setPassword(request.getPassword());
		 user.setMobileNumber(request.getMobileNumber());
		 
		 repository.save(user);
		 
		 response.setMessage("Registration Successfull");
		 response.setStatus("Success");
		 
		 return response;
		 
	 }
	 
	 public UserResponse login(LoginRequest request) {
		 
		 UserResponse response = new UserResponse();
		 
		 User user = repository.findByEmail(request.getEmail());
		 
		 if(user == null) {
			 
			 response.setMessage("User Not Found");
			 response.setMessage("Failed");
			 
			 return response;
			 
			 
		 }
		 
		 if(user.getPassword().equals(request.getPassword())) {
			 
			 response.setMessage("Login Successfull");
			 response.setStatus("Success");
		 }else {
			 
			 response.setMessage("Invalid Password");
			 response.setStatus("Failed");
			 
		 }
		 
		 return response;
	 }
	
	
	}
	
	
