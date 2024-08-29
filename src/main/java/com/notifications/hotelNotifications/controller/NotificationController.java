package com.notifications.hotelNotifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.notifications.hotelNotifications.model.NotificationDTO;
import com.notifications.hotelNotifications.model.PerformanceByPeriodDTO;
import com.notifications.hotelNotifications.service.NotificationPerformanceService;
import com.notifications.hotelNotifications.service.NotificationService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    
    @Autowired
	private NotificationPerformanceService notificationPerformanceService;

    @GetMapping
    public List<NotificationDTO> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDTO> getNotificationById(@PathVariable Long id) {
        Optional<NotificationDTO> notification = notificationService.getNotificationById(id);
        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public NotificationDTO createNotification(@RequestBody NotificationDTO notificationDTO) {
        return notificationService.createNotification(notificationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/hotel/{hotelId}")
    public List<NotificationDTO> getNotificationsByHotelId(@PathVariable Long hotelId) {
        return notificationService.getNotificationsByHotelId(hotelId);
    }
    
    @GetMapping("/performance/{id}")
    public PerformanceByPeriodDTO getPerformanceStatsByNotification(@PathVariable Long id, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return notificationPerformanceService.getPerformanceStatsByNotification(id, startDate, endDate);
    }
}