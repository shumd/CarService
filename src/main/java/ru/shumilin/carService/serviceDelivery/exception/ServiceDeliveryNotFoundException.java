package ru.shumilin.carService.serviceDelivery.exception;

public class ServiceDeliveryNotFoundException extends RuntimeException {
    public ServiceDeliveryNotFoundException(String message) {
        super(message);
    }
}
