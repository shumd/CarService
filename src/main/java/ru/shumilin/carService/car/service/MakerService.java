package ru.shumilin.carService.car.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.car.entity.MakerEntity;
import ru.shumilin.carService.car.exception.MakerNotFoundException;
import ru.shumilin.carService.car.repository.MakerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MakerService {
    private MakerRepository makerRepository;

    public List<MakerEntity> findAll(){
        List<MakerEntity> res = new ArrayList<>();
        makerRepository.findAll().forEach(res::add);
        return res;
    }

    public MakerEntity findById(Integer makerId) {
        return makerRepository.findById(makerId).orElseThrow(
                () -> new MakerNotFoundException(
                        "Производитель с id " + makerId + " не найден"
                )
        );
    }

    public MakerEntity save(MakerEntity makerEntity) {
        return makerRepository.save(makerEntity);
    }
    public MakerEntity save(String name){
        MakerEntity makerEntity = new MakerEntity();
        makerEntity.setName(name);
        return makerRepository.save(makerEntity);
    }

    public boolean delete(Integer makerId) {
        makerRepository.deleteById(makerId);
        return !makerRepository.existsById(makerId);
    }

    public MakerEntity findByName(String name) {
        return makerRepository.findByName(name).orElseThrow(
                () -> new MakerNotFoundException(
                        "Производитель с именем " + name + " не найден"
                )
        );
    }

    @Transactional
    public MakerEntity update(Integer id, String name) {
        MakerEntity entity = findById(id);
        entity.setName(name);
        return save(entity);
    }
}
