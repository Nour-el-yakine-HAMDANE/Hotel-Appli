package com.notifications.hotelNotifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notifications.hotelNotifications.mapper.HotelMapper;
import com.notifications.hotelNotifications.model.HotelEntity;
import com.notifications.hotelNotifications.model.HotelDTO;
import com.notifications.hotelNotifications.repository.HotelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelService {
	
	@Autowired
	private  HotelRepository hotelRepository;
	
	@Autowired
	private  HotelMapper hotelMapper;



	public List<HotelDTO> findAll() {
		return hotelRepository.findAll().stream().map(hotelMapper::toDTO).collect(Collectors.toList());
	}

	public HotelDTO findById(Long id) {
		return hotelRepository.findById(id).map(hotelMapper::toDTO)
				.orElseThrow(() -> new RuntimeException("Hotel not found"));
	}

	public HotelDTO save(HotelDTO hotelDTO) {
		HotelEntity hotel = hotelMapper.toEntity(hotelDTO);
		return hotelMapper.toDTO(hotelRepository.save(hotel));
	}

}
