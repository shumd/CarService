package ru.shumilin.carService.serviceDelivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shumilin.carService.car.entity.CarEntity;
import ru.shumilin.carService.human.client.entity.ClientEntity;
import ru.shumilin.carService.human.manager.entity.ManagerEntity;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;
import ru.shumilin.carService.service.entity.ServiceEntity;
import ru.shumilin.carService.serviceDeliveryStatus.entity.ServiceDeliveryStatusEntity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "carId")
    private CarEntity car;
    @ManyToOne
    @JoinColumn(name = "serviceId")
    private ServiceEntity service;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private ClientEntity client;
    @ManyToOne
    @JoinColumn(name = "mechanicId")
    private MechanicEntity mechanic;
    @ManyToOne
    @JoinColumn(name = "managerId")
    private ManagerEntity manager;
    @ManyToOne
    @JoinColumn(name = "serviceDeliveryStatusId")
    public ServiceDeliveryStatusEntity serviceDeliveryStatus;
}
