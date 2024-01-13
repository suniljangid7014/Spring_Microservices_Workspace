package com.infy.services;

import java.util.List;

import com.infy.entities.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public List<User> getAllUsers();
	
	public User getUser(String id);

}
