package com.notifications.hotelNotifications.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PerformanceByPeriodDTO {
	private Long totalImpressions;
	private Long totalClicks;
	private double ctr;
	private Long totalConversions;
	private double cvr;
}
