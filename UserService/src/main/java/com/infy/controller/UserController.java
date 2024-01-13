package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.entities.User;
import com.infy.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		User saveUser = this.userService.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id){
		User user = this.userService.getUser(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
