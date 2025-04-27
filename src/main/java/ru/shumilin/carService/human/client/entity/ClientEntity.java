package ru.shumilin.carService.human.client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shumilin.carService.car.entity.CarEntity;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.serviceDelivery.entity.ServiceDeliveryEntity;

import java.util.List;

@Entity(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn
    private NameEntity name;
    @Column(unique = true)
    private String phoneNumber;
    @Column
    private String password;
    @OneToMany
    @JoinColumn
    private List<CarEntity> carEntities;
    @OneToMany
    private List<ServiceDeliveryEntity> serviceDeliveryEntities;

    public void addCar(CarEntity car) {
        if(!carEntities.contains(car)) {
            carEntities.add(car);
        }else throw new RuntimeException("This car already exists");
    }
}