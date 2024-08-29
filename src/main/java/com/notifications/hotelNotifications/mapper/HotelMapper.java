package com.notifications.hotelNotifications.mapper;

import org.mapstruct.Mapper;

import com.notifications.hotelNotifications.model.HotelDTO;
import com.notifications.hotelNotifications.model.HotelEntity;

@Mapper(componentModel = "spring")
public interface HotelMapper {

	
	HotelDTO toDTO(HotelEntity hotelEntity);
    HotelEntity toEntity(HotelDTO hotelDTO);
}
