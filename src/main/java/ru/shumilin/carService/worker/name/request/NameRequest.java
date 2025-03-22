package ru.shumilin.carService.worker.name.request;

import lombok.Data;

@Data
public class NameRequest {
    private String name;
    private String surname;
    private String patronymic;
}
