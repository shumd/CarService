package ru.shumilin.carService.worker.status.workStatus.exception;

import ru.shumilin.carService.worker.status.exception.StatusNotFoundException;

public class WorkStatusNotFoundException extends StatusNotFoundException {
    public WorkStatusNotFoundException(String message) {
        super(message);
    }
}
