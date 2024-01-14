package com.infy.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.entities.Hotel;
import com.infy.entities.Rating;
import com.infy.entities.User;
import com.infy.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping
	public ResponseEntity<User> insertUser(@RequestBody User user) {
		User saveUser = this.userService.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		User user = this.userService.getUser(id);
		Rating[] forObject = restTemplate.getForObject("http://localhost:8083/ratings/user/" + user.getId(),
				Rating[].class);
		List<Rating> ratingsOfUser = Arrays.stream(forObject).toList();
		ratingsOfUser.forEach(e -> {
			System.out.println(e);
		});
		List<Rating> ratings = ratingsOfUser.stream().map(rating -> {
			ResponseEntity<Hotel> responseEntity = restTemplate
					.getForEntity("http://localhost:8082/hotels/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = responseEntity.getBody();
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingsOfUser);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
