package ru.shumilin.carService.human.status.workStatus.exception;

import ru.shumilin.carService.human.status.exception.StatusNotFoundException;

public class WorkStatusNotFoundException extends StatusNotFoundException {
    public WorkStatusNotFoundException(String message) {
        super(message);
    }
}
