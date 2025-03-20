package ru.shumilin.carService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Car")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String licensePlate;
    @OneToOne
    @JoinColumn(name = "maker")
    MakerEntity maker;
    String model;
    Integer odometer;
    @OneToOne
    @JoinColumn(name = "engineType")
    EngineTypeEntity engineType;
}
