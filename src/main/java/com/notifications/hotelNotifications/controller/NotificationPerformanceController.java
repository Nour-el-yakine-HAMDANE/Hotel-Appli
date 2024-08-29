package com.notifications.hotelNotifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.notifications.hotelNotifications.model.NotificationPerformanceDTO;
import com.notifications.hotelNotifications.service.NotificationPerformanceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notification-performances")
public class NotificationPerformanceController {

    @Autowired
    private NotificationPerformanceService notificationPerformanceService;

    @GetMapping
    public List<NotificationPerformanceDTO> getAllNotificationPerformances() {
        return notificationPerformanceService.getAllNotificationPerformances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationPerformanceDTO> getNotificationPerformanceById(@PathVariable Long id) {
        Optional<NotificationPerformanceDTO> notificationPerformance = notificationPerformanceService.getNotificationPerformanceById(id);
        return notificationPerformance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public NotificationPerformanceDTO createNotificationPerformance(@RequestBody NotificationPerformanceDTO notificationPerformanceDTO) {
        return notificationPerformanceService.createNotificationPerformance(notificationPerformanceDTO);
    }


    @GetMapping("/notification/{notificationId}")
    public List<NotificationPerformanceDTO> getNotificationPerformancesByNotificationId(@PathVariable Long notificationId) {
        return notificationPerformanceService.getNotificationPerformancesByNotificationId(notificationId);
    }
}