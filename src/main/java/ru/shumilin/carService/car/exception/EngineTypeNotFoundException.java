package ru.shumilin.carService.car.exception;

public class EngineTypeNotFoundException extends EntityNotFoundException {
    public EngineTypeNotFoundException(String message) {
        super(message);
    }
}
