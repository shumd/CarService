package ru.shumilin.carService.car.exception;

public class MakerNotFoundException extends EntityNotFoundException {
    public MakerNotFoundException(String message) {
        super(message);
    }
}
