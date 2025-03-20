package ru.shumilin.carService.exception;

public class MakerNotFoundException extends RuntimeException {
    public MakerNotFoundException(String message) {
        super(message);
    }
}
