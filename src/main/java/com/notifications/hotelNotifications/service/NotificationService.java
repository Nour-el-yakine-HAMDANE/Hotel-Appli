package com.notifications.hotelNotifications.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notifications.hotelNotifications.mapper.NotificationMapper;
import com.notifications.hotelNotifications.model.NotificationDTO;
import com.notifications.hotelNotifications.model.NotificationEntity;
import com.notifications.hotelNotifications.repository.NotificationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationMapper notificationMapper;

    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<NotificationDTO> getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .map(notificationMapper::toDTO);
    }

    public NotificationDTO createNotification(NotificationDTO notificationDTO) {
        NotificationEntity notificationEntity = notificationMapper.toEntity(notificationDTO);
        return notificationMapper.toDTO(notificationRepository.save(notificationEntity));
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    public List<NotificationDTO> getNotificationsByHotelId(Long hotelId) {
        return notificationRepository.findByHotelId(hotelId).stream()
                .map(notificationMapper::toDTO)
                .collect(Collectors.toList());
    }
}