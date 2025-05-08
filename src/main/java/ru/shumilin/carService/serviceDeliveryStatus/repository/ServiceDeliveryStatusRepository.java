package ru.shumilin.carService.serviceDeliveryStatus.repository;

import org.springframework.data.repository.CrudRepository;
import ru.shumilin.carService.serviceDeliveryStatus.entity.ServiceDeliveryStatusEntity;

import java.util.Optional;

public interface ServiceDeliveryStatusRepository extends CrudRepository<ServiceDeliveryStatusEntity, Integer> {
    Optional<ServiceDeliveryStatusEntity> findByStatus(String status);
    boolean existsByStatus(String status);
}
