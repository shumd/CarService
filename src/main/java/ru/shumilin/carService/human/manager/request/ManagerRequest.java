package ru.shumilin.carService.human.manager.request;

import lombok.Data;

@Data
public class ManagerRequest {
    private String name;
    private String surname;
    private String patronymic;
    private int salary;
    private String status;
    private String login;
    private String password;
}
