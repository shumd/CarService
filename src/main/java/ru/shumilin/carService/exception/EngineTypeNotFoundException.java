package ru.shumilin.carService.exception;

public class EngineTypeNotFoundException extends EntityNotFoundException {
    public EngineTypeNotFoundException(String message) {
        super(message);
    }
}
