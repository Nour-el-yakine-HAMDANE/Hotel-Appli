package com.notifications.hotelNotifications.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.notifications.hotelNotifications.model.NotificationPerformanceDTO;
import com.notifications.hotelNotifications.model.NotificationPerformanceEntity;

@Mapper(componentModel = "spring")
public interface NotificationPerformanceMapper {

    @Mapping(source = "notification.id", target = "notificationId")
    NotificationPerformanceDTO toDTO(NotificationPerformanceEntity notificationPerformanceEntity);

    @Mapping(source = "notificationId", target = "notification.id")
    NotificationPerformanceEntity toEntity(NotificationPerformanceDTO notificationPerformanceDTO);
}