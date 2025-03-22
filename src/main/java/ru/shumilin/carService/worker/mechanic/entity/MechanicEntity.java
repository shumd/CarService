package ru.shumilin.carService.worker.mechanic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shumilin.carService.worker.name.entity.NameEntity;
import ru.shumilin.carService.worker.status.workStatus.entity.WorkStatusEntity;

@Entity(name = "mechanic")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MechanicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "nameId")
    private NameEntity name;
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "workStatusId")
    private WorkStatusEntity workStatus;
}