package ru.shumilin.carService.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.service.entity.ServiceEntity;
import ru.shumilin.carService.service.service.ServiceService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/services")
@AllArgsConstructor
public class ServiceController {
    private ServiceService serviceService;

    @GetMapping("/id")
    public ServiceEntity findById(@RequestParam int id) {
        return serviceService.findById(id);
    }

    @GetMapping("/name")
    public ServiceEntity findByName(@RequestParam String name) {
        return serviceService.findByName(name);
    }

    @GetMapping("/all")
    public List<ServiceEntity> findAll() {
        return serviceService.findAll();
    }

    @PostMapping
    public ServiceEntity save(@RequestParam String name,
                              @RequestParam int price) {
        return serviceService.save(ServiceEntity
                .builder()
                .name(name)
                .price(price)
                .build());
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam int id) {
        return serviceService.deleteById(id);
    }
}
