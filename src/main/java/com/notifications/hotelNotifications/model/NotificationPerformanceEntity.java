package com.notifications.hotelNotifications.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
@Table(name = "notification_performance")
public class NotificationPerformanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "notification_id", nullable = false)
    private NotificationEntity notification;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column
    private int impressions;
    
    @Column
    private int clicks;
    
    @Column
    private double ctr;
    
    @Column
    private int conversions;
    
    @Column
    private double cvr;

}
