package ru.shumilin.carService.serviceDelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shumilin.carService.serviceDelivery.entity.ServiceDeliveryEntity;
import ru.shumilin.carService.serviceDeliveryStatus.entity.ServiceDeliveryStatusEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceDeliveryRepository extends CrudRepository<ServiceDeliveryEntity, Integer> {
    Optional<ServiceDeliveryEntity> findByClientId(int clientId);
    List<ServiceDeliveryEntity> findAllByServiceDeliveryStatus(ServiceDeliveryStatusEntity serviceDeliveryStatus);
}
