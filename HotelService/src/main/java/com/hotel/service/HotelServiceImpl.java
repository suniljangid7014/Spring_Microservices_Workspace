package com.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		Hotel save = this.hotelRepository.save(hotel);
		return save;
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		List<Hotel> hotels = this.hotelRepository.findAll();
		return hotels;
	}

	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		Hotel hotel = this.hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Resource is not found for given id "+id));
		return hotel;
	}

}
