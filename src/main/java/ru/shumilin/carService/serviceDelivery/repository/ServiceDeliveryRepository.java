package ru.shumilin.carService.serviceDelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shumilin.carService.serviceDelivery.entity.ServiceDeliveryEntity;

import java.util.Optional;

@Repository
public interface ServiceDeliveryRepository extends CrudRepository<ServiceDeliveryEntity, Integer> {
    Optional<ServiceDeliveryEntity> findByClientId(int clientId);
}
