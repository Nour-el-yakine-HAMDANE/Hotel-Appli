package com.notifications.hotelNotifications.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.notifications.hotelNotifications.model.NotificationPerformanceEntity;

public interface NotificationPerformanceRepository extends JpaRepository<NotificationPerformanceEntity, Long> {

	@Query("SELECT np FROM NotificationPerformanceEntity np WHERE np.notification.id = :notificationId")
	List<NotificationPerformanceEntity> findByNotificationId(@Param("notificationId") Long notificationId);

	@Query("SELECT SUM(np.impressions) FROM NotificationPerformanceEntity np WHERE np.notification.id = :notificationId AND np.date BETWEEN :startDate AND :endDate")
	Long getTotalImpressionsByNotification(@Param("notificationId") Long notificationId,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query("SELECT SUM(np.clicks) FROM NotificationPerformanceEntity np WHERE np.notification.id = :notificationId AND np.date BETWEEN :startDate AND :endDate")
	Long getTotalClicksByNotification(@Param("notificationId") Long notificationId, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);

	@Query("SELECT SUM(np.conversions) FROM NotificationPerformanceEntity np WHERE np.notification.id = :notificationId AND np.date BETWEEN :startDate AND :endDate")
	Long getTotalConversionsByNotification(@Param("notificationId") Long notificationId,
			@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}