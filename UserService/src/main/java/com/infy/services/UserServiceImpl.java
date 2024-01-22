package com.infy.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.entities.Hotel;
import com.infy.entities.Rating;
import com.infy.entities.User;
import com.infy.exception.ResourceNotFoundException;
import com.infy.externalservices.HotelService;
import com.infy.externalservices.RatingService;
import com.infy.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;

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
		List<Rating> ratingsOfUser = ratingService.getRatings(user.getId());
//		List<Rating> ratingsOfUser = Arrays.stream(forObject).toList();
//		ratingsOfUser.forEach(e -> {
//			System.out.println(e);
//		});
		List<Rating> ratings = ratingsOfUser.stream().map(rating -> {
//			ResponseEntity<Hotel> responseEntity = restTemplate
//					.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//			Hotel hotel = responseEntity.getBody();
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingsOfUser);
		return user;
	}

}
