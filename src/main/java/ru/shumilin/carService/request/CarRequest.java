package ru.shumilin.carService.request;

import lombok.Data;

@Data
public class CarRequest {
    private String licensePlate;
    private Integer makerId;
    private String model;
    private Integer odometer;
    private Integer engineId;
}
