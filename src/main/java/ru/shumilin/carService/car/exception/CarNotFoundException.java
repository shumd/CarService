package ru.shumilin.carService.car.exception;

public class CarNotFoundException extends EntityNotFoundException {
    public CarNotFoundException(String message) {
        super(message);
    }
}
