package ru.shumilin.carService.human.name.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.name.request.NameRequest;
import ru.shumilin.carService.human.name.service.NameService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/name")
@AllArgsConstructor
public class NameController {
    private final NameService nameService;

    @GetMapping
    public NameEntity getNameById(@RequestParam int id) {
        return nameService.findById(id);
    }
    @GetMapping("/all")
    public List<NameEntity> getAllNames() {
        return nameService.findAll();
    }
    @GetMapping("/sur")
    public List<NameEntity> getNamesBySurname(@RequestParam String surname) {
        return nameService.findBySurname(surname);
    }

    @PostMapping
    public NameEntity createName(@RequestBody NameRequest nameRequest) {
        return nameService.save(toEntity(nameRequest));
    }

    @DeleteMapping
    public void deleteNameById(@RequestParam int id) {
        nameService.delete(id);
    }

    private NameEntity toEntity(NameRequest nameRequest) {
        return NameEntity.builder()
                .name(nameRequest.getName())
                .surname(nameRequest.getSurname())
                .patronymic(nameRequest.getPatronymic())
                .build();
    }
}
