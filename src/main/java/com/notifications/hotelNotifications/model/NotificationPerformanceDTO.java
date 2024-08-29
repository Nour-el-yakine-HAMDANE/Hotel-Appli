package com.notifications.hotelNotifications.model;

import lombok.Data;
import java.util.Date;

@Data
public class NotificationPerformanceDTO {
	private Long id;
	private Long notificationId;
	private Date date;
	private int impressions;
	private int clicks;
	private double ctr;
	private int conversions;
	private double cvr;
}