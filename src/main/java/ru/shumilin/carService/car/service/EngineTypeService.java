package ru.shumilin.carService.car.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.car.entity.EngineTypeEntity;
import ru.shumilin.carService.car.exception.EngineTypeNotFoundException;
import ru.shumilin.carService.car.repository.EngineTypeRepository;

@AllArgsConstructor
@Service
public class EngineTypeService {
    private EngineTypeRepository engineTypeRepository;

    public boolean save(EngineTypeEntity entity) {
        engineTypeRepository.save(entity);
        return engineTypeRepository.existsById(entity.getId());
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
}
