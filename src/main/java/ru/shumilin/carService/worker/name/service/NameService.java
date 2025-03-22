package ru.shumilin.carService.worker.name.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.worker.name.entity.NameEntity;
import ru.shumilin.carService.worker.name.exception.NameNotFoundException;
import ru.shumilin.carService.worker.name.repository.NameRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class NameService {
    private NameRepository repo;

    public NameEntity findById(long id) {
        return repo.findById(id).orElseThrow(
                () -> new NameNotFoundException(
                        "Имя с " + id + " не найдено"
                )
        );
    }
    public List<NameEntity> findAll() {
        List<NameEntity> res = new ArrayList<>();
        repo.findAll().iterator().forEachRemaining(res::add);
        return res;
    }
    public List<NameEntity> findBySurname(String surname) {
        List<NameEntity> res = new ArrayList<>();

        Iterable<NameEntity> iterable = repo.findBySurname(surname).orElseThrow(
                () -> new NameNotFoundException(
                        "Имя с фамилией " + surname + " не найдено"
                )
        );

        iterable.iterator().forEachRemaining(res::add);
        return res;
    }

    public NameEntity save(NameEntity entity) {
        return repo.save(entity);
    }

    public NameEntity delete(long id) {
        NameEntity entity = findById(id);
        repo.delete(entity);
        return entity;
    }
}
