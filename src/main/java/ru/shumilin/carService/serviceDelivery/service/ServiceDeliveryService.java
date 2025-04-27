package ru.shumilin.carService.serviceDelivery.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.car.service.CarService;
import ru.shumilin.carService.human.client.service.ClientService;
import ru.shumilin.carService.human.manager.service.ManagerService;
import ru.shumilin.carService.human.mechanic.service.MechanicService;
import ru.shumilin.carService.service.service.ServiceService;
import ru.shumilin.carService.serviceDelivery.entity.ServiceDeliveryEntity;
import ru.shumilin.carService.serviceDelivery.exception.ServiceDeliveryNotFoundException;
import ru.shumilin.carService.serviceDelivery.repository.ServiceDeliveryRepository;
import ru.shumilin.carService.serviceDelivery.request.ServiceDeliveryRequest;
import ru.shumilin.carService.serviceDeliveryStatus.service.ServiceDeliveryStatusService;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceDeliveryService {
    private ServiceDeliveryRepository serviceDeliveryRepository;

    private ServiceDeliveryStatusService serviceDeliveryStatusService;
    private CarService carService;
    private ServiceService serviceService;
    private ClientService clientService;
    private MechanicService mechanicService;
    private ManagerService managerService;

    public List<ServiceDeliveryEntity> findByServiceDeliveryStatus(String statusName){
        return serviceDeliveryRepository.findAllByServiceDeliveryStatus(serviceDeliveryStatusService.findByStatus(statusName));
    }

    public ServiceDeliveryEntity findById(int id) {
        return serviceDeliveryRepository.findById(id).orElseThrow(
                () -> new ServiceDeliveryNotFoundException(
                        "Заказ с id " + id + " не найден"
                )
        );
    }

    public ServiceDeliveryEntity findByClientId(int clientId) {
        return serviceDeliveryRepository.findByClientId(clientId).orElseThrow(
                () -> new ServiceDeliveryNotFoundException(
                        "Заказ с clientId " + clientId + " не найден"
                )
        );
    }

    public ServiceDeliveryEntity save(ServiceDeliveryEntity serviceDeliveryEntity) {
        return serviceDeliveryRepository.save(serviceDeliveryEntity);
    }

    public boolean deleteById(int id) {
        serviceDeliveryRepository.deleteById(id);
        return !serviceDeliveryRepository.existsById(id);
    }

    public ServiceDeliveryEntity toEntity(ServiceDeliveryRequest request){
        return ServiceDeliveryEntity.builder()
                .serviceDeliveryStatus(serviceDeliveryStatusService.findById(request.getServiceDeliveryStatusId()))
                .car(carService.findById(request.getCarId()))
                .client(clientService.findById(request.getClientId()))
                .service(serviceService.findById(request.getServiceId()))
                .manager(managerService.findById(request.getManagerId()))
                .mechanic(mechanicService.getMechanicById(request.getMechanicId()))
                .build();
    }
}
