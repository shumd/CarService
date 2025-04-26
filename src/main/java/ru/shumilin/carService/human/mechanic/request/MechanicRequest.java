package ru.shumilin.carService.human.mechanic.request;

import lombok.Data;

@Data
public class MechanicRequest {
    private String name;
    private String surname;
    private String patronymic;
    private int salary;
}
