package com.notifications.hotelNotifications.model;

import java.util.Date;

import lombok.Data;

@Data
public class NotificationDTO {

	private Long id;

	private Long hotelId;

	private String message;

	private Date creationDate;

}