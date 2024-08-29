package com.notifications.hotelNotifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.notifications.hotelNotifications.model.HotelDTO;
import com.notifications.hotelNotifications.service.HotelService;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {
	
	@Autowired
    private HotelService hotelService;


    @GetMapping
    public List<HotelDTO> getAllHotels() {
        return hotelService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HotelDTO> createHotel(@RequestBody HotelDTO hotelDTO) {
        return ResponseEntity.ok(hotelService.save(hotelDTO));
    }

}