package ru.shumilin.carService.human.name.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.name.exception.NameNotFoundException;
import ru.shumilin.carService.human.name.repository.NameRepository;

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

    public NameEntity saveIfNotExists(NameEntity entity) {
        if(existByFullName(entity)){
            return entity;
        }
        return save(entity);
    }

    public boolean existByFullName(NameEntity entity) {
        return repo.existsByNameAndSurnameAndPatronymic(entity.getName(), entity.getSurname(), entity.getPatronymic());
    }
    public boolean existByFullName(String name, String surname, String patronymic) {
        return repo.existsByNameAndSurnameAndPatronymic(name, surname, patronymic);
    }
}
