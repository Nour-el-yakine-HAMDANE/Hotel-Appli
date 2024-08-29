package com.notifications.hotelNotifications.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.notifications.hotelNotifications.model.NotificationEntity;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {

	@Query("SELECT n FROM NotificationEntity n WHERE n.hotel.id = :hotelId")
	List<NotificationEntity> findByHotelId(@Param("hotelId") Long hotelId);
}