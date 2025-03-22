package ru.shumilin.carService.worker.mechanic.exception;

import ru.shumilin.carService.worker.exception.WorkerNotFoundException;

public class MechanicNotFoundException extends WorkerNotFoundException {
    public MechanicNotFoundException(String message) {
        super(message);
    }
}
