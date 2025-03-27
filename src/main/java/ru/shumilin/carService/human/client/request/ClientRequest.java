package ru.shumilin.carService.human.client.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClientRequest {
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
}
