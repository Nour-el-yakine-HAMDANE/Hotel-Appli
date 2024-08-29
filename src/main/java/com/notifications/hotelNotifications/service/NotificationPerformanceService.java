package com.notifications.hotelNotifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifications.hotelNotifications.mapper.NotificationPerformanceMapper;
import com.notifications.hotelNotifications.model.NotificationPerformanceDTO;
import com.notifications.hotelNotifications.model.NotificationPerformanceEntity;
import com.notifications.hotelNotifications.model.PerformanceByPeriodDTO;
import com.notifications.hotelNotifications.repository.NotificationPerformanceRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationPerformanceService {

    @Autowired
    private NotificationPerformanceRepository notificationPerformanceRepository;

    @Autowired
    private NotificationPerformanceMapper notificationPerformanceMapper;

    public List<NotificationPerformanceDTO> getAllNotificationPerformances() {
        return notificationPerformanceRepository.findAll().stream()
                .map(notificationPerformanceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificationPerformanceDTO> getNotificationPerformanceById(Long id) {
        return notificationPerformanceRepository.findById(id)
                .map(notificationPerformanceMapper::toDTO);
    }

    public NotificationPerformanceDTO createNotificationPerformance(NotificationPerformanceDTO notificationPerformanceDTO) {
        NotificationPerformanceEntity notificationPerformanceEntity = notificationPerformanceMapper.toEntity(notificationPerformanceDTO);
        return notificationPerformanceMapper.toDTO(notificationPerformanceRepository.save(notificationPerformanceEntity));
    }

    public List<NotificationPerformanceDTO> getNotificationPerformancesByNotificationId(Long notificationId) {
        return notificationPerformanceRepository.findByNotificationId(notificationId).stream()
                .map(notificationPerformanceMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public PerformanceByPeriodDTO getPerformanceStatsByNotification(Long notificationId, Date startDate, Date endDate) {
        Long totalImpressions = notificationPerformanceRepository.getTotalImpressionsByNotification(notificationId, startDate, endDate);
        Long totalClicks = notificationPerformanceRepository.getTotalClicksByNotification(notificationId, startDate, endDate);
        Long totalConversions = notificationPerformanceRepository.getTotalConversionsByNotification(notificationId, startDate, endDate);

        double ctr = (totalImpressions != null && totalImpressions > 0) ? (double) totalClicks / totalImpressions : 0;
        double cvr = (totalClicks != null && totalClicks > 0) ? (double) totalConversions / totalClicks : 0;

        return new PerformanceByPeriodDTO(totalImpressions, totalClicks, ctr, totalConversions, cvr);
    }
}