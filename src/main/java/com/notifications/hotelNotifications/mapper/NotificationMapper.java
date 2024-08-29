package com.notifications.hotelNotifications.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.notifications.hotelNotifications.model.NotificationDTO;
import com.notifications.hotelNotifications.model.NotificationEntity;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

	@Mapping(source = "hotel.id", target = "hotelId")
	NotificationDTO toDTO(NotificationEntity notificationEntity);

	@Mapping(source = "hotelId", target = "hotel.id")
	NotificationEntity toEntity(NotificationDTO notificationDTO);

}