package ru.shumilin.carService.human.mechanic.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.shumilin.carService.human.mechanic.entity.MechanicEntity;
import ru.shumilin.carService.human.mechanic.exception.MechanicNotFoundException;
import ru.shumilin.carService.human.mechanic.repository.MechanicRepository;

@Service
@AllArgsConstructor
@CrossOrigin
public class MechanicService {
    private MechanicRepository mechanicRepository;

    public MechanicEntity getMechanicById(long id) {
        return mechanicRepository.findById(id).orElseThrow(
                () -> new MechanicNotFoundException(
                        "Механик с id " + id + " не найден"
                )
        );
    }
//    public MechanicEntity getMechanicByName(String name) {
//        return mechanicRepository.findByName(name).orElseThrow(
//                () -> new MechanicNotFoundException(
//                        "Механик с именем " + name + " не найден"
//                )
//        );
//    }
}
