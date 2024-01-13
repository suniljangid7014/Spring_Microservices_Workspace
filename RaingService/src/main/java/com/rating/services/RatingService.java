package com.rating.services;

import java.util.List;

import com.rating.entities.Rating;

public interface RatingService {
	
//	Save Rating
	Rating saveRating(Rating rating);
	
//	Get All Ratings	
	List<Rating> getAllRatings();
	
	
//	get all ratings by user Id
	List<Rating> getRatingsByUserId(String userId);
	
//	get all ratings by hotel Id
	List<Rating> getRatingsByHotelId(String hotelId);

}
