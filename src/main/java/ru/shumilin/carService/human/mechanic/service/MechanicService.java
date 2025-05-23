package ru.shumilin.carService.human.mechanic.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;
import ru.shumilin.carService.human.mechanic.exception.MechanicNotFoundException;
import ru.shumilin.carService.human.mechanic.repository.MechanicRepository;
import ru.shumilin.carService.human.mechanic.request.MechanicRequest;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.name.service.NameService;
import ru.shumilin.carService.human.status.workStatus.entity.WorkStatusEntity;
import ru.shumilin.carService.human.status.workStatus.service.WorkStatusService;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MechanicService {
    private MechanicRepository mechanicRepository;
    private WorkStatusService workStatusService;
    private NameService nameService;

    public List<MechanicEntity> findAll() {
        List<MechanicEntity> res = new ArrayList<>();
        mechanicRepository.findAll().forEach(res::add);
        return res;
    }

    public MechanicEntity getMechanicById(long id) {
        return mechanicRepository.findById(id).orElseThrow(
                () -> new MechanicNotFoundException(
                        "Механик с id " + id + " не найден"
                )
        );
    }

    public List<MechanicEntity> getMechanicBySurname(String surname) {
        List<NameEntity> nameEntities = nameService.findBySurname(surname);
        List<MechanicEntity> mechanics = new ArrayList<>();

        for(NameEntity nameEntity : nameEntities) {
            mechanicRepository.findByName(nameEntity).orElseThrow(
                    () -> new MechanicNotFoundException(
                            "Механик с именем " + nameEntity + " не найден"
                    )
            );
        }

        return mechanics;
    }

    public MechanicEntity save(MechanicEntity mechanic) {
        return mechanicRepository.save(mechanic);
    }
    public MechanicEntity save(MechanicRequest request) {
        MechanicEntity entity = toEntity(request);
        return mechanicRepository.save(entity);
    }

    public boolean deleteMechanicById(long id) {
        mechanicRepository.deleteById(id);
        return !mechanicRepository.existsById(id);
    }

    public MechanicEntity toEntity(MechanicRequest request){
        return MechanicEntity.builder()
                .name(
                        nameService.saveIfNotExists(
                            NameEntity.builder()
                                    .name(request.getName())
                                    .surname(request.getSurname())
                                    .patronymic(request.getPatronymic())
                                    .build()
                        )
                )
                .salary(request.getSalary())
                .workStatus(defaultStatus())
                .build();
    }

    private WorkStatusEntity defaultStatus(){
        String status = "работает";
        if(!workStatusService.existByStatus(status)){
            workStatusService.save(WorkStatusEntity.builder().status(status).build());
        }
        return workStatusService.findStatusByStatusName(status);
    }

    public List<MechanicEntity> findByWorkStatus(String status) {
        WorkStatusEntity workStatusEntity = workStatusService.findStatusByStatusName(status);
        return mechanicRepository.findAllByWorkStatus(workStatusEntity);
    }

    @Transactional
    public void updateSalary(int id, int amount) {
        mechanicRepository.updateMechanicSalary(id, amount);
    }
}
