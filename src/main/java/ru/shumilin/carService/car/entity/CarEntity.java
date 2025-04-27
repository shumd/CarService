package ru.shumilin.carService.car.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.shumilin.carService.human.client.entity.ClientEntity;

@Entity(name = "Car")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String licensePlate;
    @ManyToOne
    @JoinColumn(name = "makerId")
    private MakerEntity maker;
    private String model;
    private Integer odometer;
    @ManyToOne
    @JoinColumn(name = "engineTypeId")
    private EngineTypeEntity engineType;
}
