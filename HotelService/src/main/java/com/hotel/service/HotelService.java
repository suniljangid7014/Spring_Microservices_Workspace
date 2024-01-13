package com.hotel.service;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelService {
	
	public Hotel saveHotel(Hotel hotel);
	
	public List<Hotel> getAllHotels();
	
	public Hotel getHotel(String id);

}
