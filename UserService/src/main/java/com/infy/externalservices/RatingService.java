package com.infy.externalservices;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.infy.entities.Rating;

@FeignClient("RATING-SERVICE")
public interface RatingService {
	
	@GetMapping("/ratings/user/{id}")
	public List<Rating> getRatings(@PathVariable String id);
	
	@PostMapping("/ratings")
	public void createRating(@RequestBody Rating rating);
	
	@PutMapping("/ratings/{id}")
	public Rating updateRating(@PathVariable String id, Rating rating);
	
	@DeleteMapping("/ratings/{id}")
	public void deleteRaring(@PathVariable String id);

}
