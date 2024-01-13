package com.rating.controller;

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

import com.rating.entities.Rating;
import com.rating.services.RatingService;

@RestController
@RequestMapping("ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
		Rating saveRating = this.ratingService.saveRating(rating);
		return new ResponseEntity<Rating>(saveRating, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings = this.ratingService.getAllRatings();
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		List<Rating> ratingsByHotelId = this.ratingService.getRatingsByHotelId(hotelId);
		return ResponseEntity.ok(ratingsByHotelId);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		List<Rating> ratingsByUserId = this.ratingService.getRatingsByUserId(userId);
		return ResponseEntity.ok(ratingsByUserId);
	}

}
