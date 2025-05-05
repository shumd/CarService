package ru.shumilin.carService.serviceDeliveryStatus.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.serviceDeliveryStatus.entity.ServiceDeliveryStatusEntity;
import ru.shumilin.carService.serviceDeliveryStatus.exception.ServiceDeliveryStatusNotFoundException;
import ru.shumilin.carService.serviceDeliveryStatus.repository.ServiceDeliveryStatusRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceDeliveryStatusService {
    private ServiceDeliveryStatusRepository serviceDeliveryStatusRepository;

    public ServiceDeliveryStatusEntity save(ServiceDeliveryStatusEntity entity){
        return serviceDeliveryStatusRepository.save(entity);
    }

    public void deleteByStatus(String status){
        serviceDeliveryStatusRepository.deleteByStatus(status);
    }

    public ServiceDeliveryStatusEntity findById(Integer id){
        return serviceDeliveryStatusRepository.findById(id).orElseThrow(
                () -> new ServiceDeliveryStatusNotFoundException(
                        "Статус услуги с id " + id + " не найден"
                )
        );
    }

    public ServiceDeliveryStatusEntity findByStatus(String status){
        return serviceDeliveryStatusRepository.findByStatus(status).orElseThrow(
                () -> new ServiceDeliveryStatusNotFoundException(
                        "Статус услуги со статусом " + status + " не найден"
                )
        );
    }

    public boolean existsByStatus(String status){
        return serviceDeliveryStatusRepository.existsByStatus(status);
    }

    public List<ServiceDeliveryStatusEntity> findAll() {
        List<ServiceDeliveryStatusEntity> res = new ArrayList<>();
        serviceDeliveryStatusRepository.findAll().forEach(res::add);
        return res;
    }
}