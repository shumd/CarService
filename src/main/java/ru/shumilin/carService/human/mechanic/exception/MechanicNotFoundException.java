package ru.shumilin.carService.human.mechanic.exception;

import ru.shumilin.carService.human.exception.WorkerNotFoundException;

public class MechanicNotFoundException extends WorkerNotFoundException {
    public MechanicNotFoundException(String message) {
        super(message);
    }
}
