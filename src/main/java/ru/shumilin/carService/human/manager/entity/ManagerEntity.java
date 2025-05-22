package ru.shumilin.carService.human.manager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;

@Entity(name = "manager")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ManagerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "name_id")
    private NameEntity name;
    private int salary;
    @ManyToOne
    @JoinColumn(name = "work_status_id")
    private WorkStatusEntity workStatus;
    @Column(unique = true)
    private String login;
    private String password;
}

