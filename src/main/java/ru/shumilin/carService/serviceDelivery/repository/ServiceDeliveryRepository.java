package ru.shumilin.carService.serviceDelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.serviceDelivery.entity.ServiceDeliveryEntity;
import ru.shumilin.carService.serviceDeliveryStatus.entity.ServiceDeliveryStatusEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceDeliveryRepository extends CrudRepository<ServiceDeliveryEntity, Integer> {
    List<ServiceDeliveryEntity> findAllByClientId(int clientId);
    List<ServiceDeliveryEntity> findAllByServiceDeliveryStatus(ServiceDeliveryStatusEntity serviceDeliveryStatus);
    List<ServiceDeliveryEntity> findAllByManagerId(long managerId);
    List<ServiceDeliveryEntity> findAllByMechanicId(long mechanicId);
}
