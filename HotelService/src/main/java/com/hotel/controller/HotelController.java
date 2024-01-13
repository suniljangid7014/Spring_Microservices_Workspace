package com.hotel.controller;

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

import com.hotel.entities.Hotel;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("hotels")
public class HotelController {
	
	@Autowired
	private HotelService service;
	
	@PostMapping
	public ResponseEntity<Hotel> insertHotel(@RequestBody Hotel hotel) {
		Hotel hotel2 = this.service.saveHotel(hotel);
		return new ResponseEntity<Hotel>(hotel2, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotels = this.service.getAllHotels();
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		Hotel hotel = this.service.getHotel(id);
		return ResponseEntity.ok(hotel);
	}

}
