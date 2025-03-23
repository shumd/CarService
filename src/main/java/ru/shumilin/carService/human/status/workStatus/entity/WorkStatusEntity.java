package ru.shumilin.carService.human.status.workStatus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "work_status")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String status;
}
