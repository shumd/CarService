package ru.shumilin.carService.car.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.car.entity.EngineTypeEntity;
import ru.shumilin.carService.car.exception.EngineTypeNotFoundException;
import ru.shumilin.carService.car.repository.EngineTypeRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EngineTypeService {
    private EngineTypeRepository engineTypeRepository;

    public List<EngineTypeEntity> findAll() {
        List<EngineTypeEntity> res = new ArrayList<>();
        engineTypeRepository.findAll().forEach(res::add);
        return res;
    }

    public EngineTypeEntity save(EngineTypeEntity entity) {
        return engineTypeRepository.save(entity);
    }
    public EngineTypeEntity save(String type){
        EngineTypeEntity entity = new EngineTypeEntity();
        entity.setType(type);
        return engineTypeRepository.save(entity);
    }

    public boolean delete(int id) {
        engineTypeRepository.deleteById(id);
        return !engineTypeRepository.existsById(id);
    }

    public EngineTypeEntity findById(int id) {
        return engineTypeRepository.findById(id).orElseThrow(
                () -> new EngineTypeNotFoundException(
                        "Двигатель с id " + id + " не найден"
                )
        );
    }

    public EngineTypeEntity findByType(String type) {
        return engineTypeRepository.findByType(type).
                orElseThrow(
                        () -> new EngineTypeNotFoundException(
                                "Двигатель с типом " + type + " не найден"
                ));
    }

    @Transactional
    public EngineTypeEntity update(int id, String type) {
        EngineTypeEntity entity = findById(id);
        entity.setType(type);
        return engineTypeRepository.save(entity);
    }
}
