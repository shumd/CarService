package ru.shumilin.carService.human.mechanic.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;
import ru.shumilin.carService.human.mechanic.request.MechanicRequest;
import ru.shumilin.carService.human.mechanic.service.MechanicService;

import java.util.List;

@RestController
@RequestMapping("/mechanics")
@CrossOrigin
@AllArgsConstructor
public class MechanicController {
    private MechanicService mechanicService;

    @GetMapping
    @RequestMapping("/{id}")
    public MechanicEntity findMechanicById(@PathVariable long id) {
        return mechanicService.getMechanicById(id);
    }

    @GetMapping
    @RequestMapping("/surname")
    public List<MechanicEntity> findMechanicBySurname(@RequestParam String surname) {
        return mechanicService.getMechanicBySurname(surname);
    }

    @GetMapping
    @RequestMapping("/all")
    public List<MechanicEntity> findAllMechanic() {
        return mechanicService.findAll();
    }

    @GetMapping
    @RequestMapping("/status")
    public List<MechanicEntity> findMechanicByWorkStatus(@RequestParam String status) {
        return mechanicService.findByWorkStatus(status);
    }

    @PostMapping
    public MechanicEntity save(@RequestBody MechanicRequest request){
        return mechanicService.save(request);
    }

    @PostMapping("/salary")
    public void updateSalary(@RequestParam int id, @RequestParam int amount) {
        mechanicService.updateSalary(id, amount);
    }

    @DeleteMapping("/{id}")
    public boolean deleteMechanicById(@PathVariable long id) {
        return mechanicService.deleteMechanicById(id);
    }
}
