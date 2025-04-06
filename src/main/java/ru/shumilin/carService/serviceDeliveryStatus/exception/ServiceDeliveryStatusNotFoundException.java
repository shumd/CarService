package ru.shumilin.carService.serviceDeliveryStatus.exception;

public class ServiceDeliveryStatusNotFoundException extends RuntimeException {
    public ServiceDeliveryStatusNotFoundException(String message) {
        super(message);
    }
}
