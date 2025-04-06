package ru.shumilin.carService.serviceDelivery.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.serviceDelivery.entity.ServiceDeliveryEntity;
import ru.shumilin.carService.serviceDelivery.request.ServiceDeliveryRequest;
import ru.shumilin.carService.serviceDelivery.service.ServiceDeliveryService;

@RestController
@RequestMapping("/serviceDelivery")
@AllArgsConstructor
public class ServiceDeliveryController {
    private ServiceDeliveryService serviceDeliveryService;

    @GetMapping("/id")
    public ServiceDeliveryEntity findById(@RequestParam int id) {
        return serviceDeliveryService.findById(id);
    }

    @GetMapping("/clientId")
    public ServiceDeliveryEntity findByClientId(@RequestParam int clientId) {
        return serviceDeliveryService.findByClientId(clientId);
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
