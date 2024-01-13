package com.infy.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.entities.User;
import com.infy.exception.ResourceNotFoundException;
import com.infy.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setId(id);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		return users;
	}

	@Override
	public User getUser(String id) {
		User user = this.userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found for given id "+id));
		return user;
	}

}
