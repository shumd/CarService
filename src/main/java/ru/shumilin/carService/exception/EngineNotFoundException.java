package ru.shumilin.carService.exception;

public class EngineNotFoundException extends RuntimeException {
    public EngineNotFoundException(String message) {
        super(message);
    }
}
