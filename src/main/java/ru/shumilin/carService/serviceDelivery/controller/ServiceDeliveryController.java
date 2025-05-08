package ru.shumilin.carService.serviceDelivery.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.serviceDelivery.entity.ServiceDeliveryEntity;
import ru.shumilin.carService.serviceDelivery.request.ServiceDeliveryRequest;
import ru.shumilin.carService.serviceDelivery.service.ServiceDeliveryService;

import java.util.List;

@RestController
@RequestMapping("/serviceDelivery")
@AllArgsConstructor
public class ServiceDeliveryController {
    private ServiceDeliveryService serviceDeliveryService;

    @GetMapping("/id")
    public ServiceDeliveryEntity findById(@RequestParam int id) {
        return serviceDeliveryService.findById(id);
    }

    @GetMapping("/all")
    public List<ServiceDeliveryEntity> findAll() {
        return serviceDeliveryService.findAll();
    }

    @GetMapping("/{status}")
    public List<ServiceDeliveryEntity> findByStatus(@PathVariable String status) {
        return serviceDeliveryService.findByServiceDeliveryStatus(status);
    }

    @GetMapping("/mechanic")
    public List<ServiceDeliveryEntity> findByMechanic(@RequestParam int id) {
        return serviceDeliveryService.findAllByMechanicId(id);
    }

    @GetMapping("/manager")
    public List<ServiceDeliveryEntity> findByManager(@RequestParam long id) {
        return serviceDeliveryService.findByManagerId(id);
    }

    @GetMapping("/clientId")
    public List<ServiceDeliveryEntity> findByClientId(@RequestParam int clientId) {
        return serviceDeliveryService.findByClientId(clientId);
    }

    @PutMapping("/{id}")
    public ServiceDeliveryEntity update(@PathVariable int id, @RequestBody ServiceDeliveryRequest serviceDeliveryRequest) {
        return serviceDeliveryService.update(id, serviceDeliveryRequest);
    }

    @PostMapping
    public ServiceDeliveryEntity save(@RequestBody ServiceDeliveryRequest serviceDeliveryRequest) {
        return serviceDeliveryService.save(serviceDeliveryService.toEntity(serviceDeliveryRequest));
    }

    @DeleteMapping
    public boolean delete(@RequestParam int id) {
        return serviceDeliveryService.deleteById(id);
    }
}
