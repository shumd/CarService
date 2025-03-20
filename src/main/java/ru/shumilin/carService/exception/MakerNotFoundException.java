package ru.shumilin.carService.exception;

public class MakerNotFoundException extends EntityNotFoundException {
    public MakerNotFoundException(String message) {
        super(message);
    }
}
