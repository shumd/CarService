package ru.shumilin.carService.serviceDelivery.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.car.service.CarService;
import ru.shumilin.carService.human.client.service.ClientService;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;
import ru.shumilin.carService.human.manager.service.ManagerService;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;
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

    public List<ServiceDeliveryEntity> findByManagerId(long managerId){
        return serviceDeliveryRepository.findAllByManagerId(managerId);
    }

    public ServiceDeliveryEntity findById(int id) {
        return serviceDeliveryRepository.findById(id).orElseThrow(
                () -> new ServiceDeliveryNotFoundException(
                        "Заказ с id " + id + " не найден"
                )
        );
    }

    public List<ServiceDeliveryEntity> findAllByMechanicId(long mechanicId){
        return serviceDeliveryRepository.findAllByMechanicId(mechanicId);
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
        ManagerEntity managerEntity = request.getManagerId() < 0 ? null : managerService.findById(request.getManagerId());
        MechanicEntity mechanicEntity = request.getMechanicId() < 0 ? null : mechanicService.getMechanicById(request.getMechanicId());

        return ServiceDeliveryEntity.builder()
                .serviceDeliveryStatus(serviceDeliveryStatusService.findById(request.getServiceDeliveryStatusId()))
                .car(carService.findById(request.getCarId()))
                .client(clientService.findById(request.getClientId()))
                .service(serviceService.findById(request.getServiceId()))
                .manager(managerEntity)
                .mechanic(mechanicEntity)
                .build();
    }

    @Transactional
    public ServiceDeliveryEntity update(int id, ServiceDeliveryRequest serviceDeliveryRequest) {
        ServiceDeliveryEntity serviceDeliveryEntity = findById(id);

        serviceDeliveryEntity.setService(serviceDeliveryEntity.getService());
        serviceDeliveryEntity.setCar(carService.findById(serviceDeliveryRequest.getCarId()));
        serviceDeliveryEntity.setClient(clientService.findById(serviceDeliveryRequest.getClientId()));
        serviceDeliveryEntity.setManager(managerService.findById(serviceDeliveryRequest.getManagerId()));
        serviceDeliveryEntity.setServiceDeliveryStatus(serviceDeliveryStatusService.findById(serviceDeliveryRequest.getServiceDeliveryStatusId()));
        serviceDeliveryEntity.setMechanic(mechanicService.getMechanicById(serviceDeliveryRequest.getMechanicId()));

        return serviceDeliveryRepository.save(serviceDeliveryEntity);
    }
}
