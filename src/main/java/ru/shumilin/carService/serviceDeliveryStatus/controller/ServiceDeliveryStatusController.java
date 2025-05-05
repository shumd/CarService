package ru.shumilin.carService.serviceDeliveryStatus.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.serviceDeliveryStatus.entity.ServiceDeliveryStatusEntity;
import ru.shumilin.carService.serviceDeliveryStatus.service.ServiceDeliveryStatusService;

import java.util.List;

@RestController
@RequestMapping("/deliveryStatus")
@CrossOrigin
@AllArgsConstructor
public class ServiceDeliveryStatusController {
    private ServiceDeliveryStatusService serviceDeliveryStatusService;

    @GetMapping("/id")
    public ServiceDeliveryStatusEntity findById(@RequestParam Integer id) {
        return serviceDeliveryStatusService.findById(id);
    }

    @GetMapping
    @RequestMapping("/all")
    public List<ServiceDeliveryStatusEntity> all(){
        return serviceDeliveryStatusService.findAll();
    }

    @GetMapping("/status")
    public ServiceDeliveryStatusEntity findByStatus(@RequestParam String status) {
        return serviceDeliveryStatusService.findByStatus(status);
    }

    @DeleteMapping
    public void deleteByStatus(@RequestParam String status) {
        serviceDeliveryStatusService.deleteByStatus(status);
    }

    @PostMapping
    public ServiceDeliveryStatusEntity save(@RequestParam String status) {
        return serviceDeliveryStatusService.save(ServiceDeliveryStatusEntity
                .builder()
                .status(status)
                .build()
        );
    }

}
