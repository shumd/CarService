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
    private Long id;
    private String licensePlate;
    @OneToOne
    @JoinColumn(name = "maker")
    private MakerEntity maker;
    private String model;
    private Integer odometer;
    @OneToOne
    @JoinColumn(name = "engineType")
    private EngineTypeEntity engineType;
}
