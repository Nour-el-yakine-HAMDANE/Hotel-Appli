package com.notifications.hotelNotifications.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.notifications.hotelNotifications.model.HotelEntity;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
	
	@Modifying
    @Query(value = "INSERT INTO hotel (name, key) VALUES (:name, :key) ON DUPLICATE KEY UPDATE name = :name", nativeQuery = true)
	HotelEntity saveOrUpdate(@Param("name") String name, @Param("key") String key);
}