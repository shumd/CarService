package ru.shumilin.carService.car.request;

import lombok.Data;

@Data
public class CarRequest {
    private String licensePlate;
    private String maker;
    private String model;
    private Integer odometer;
    private String engineType;
}
