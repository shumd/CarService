package ru.shumilin.carService.serviceDeliveryStatus.entity;

import jakarta.persistence.*;

@Entity
public class ServiceDeliveryStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique=true)
    private String status;
}
