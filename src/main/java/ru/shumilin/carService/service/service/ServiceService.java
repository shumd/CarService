package ru.shumilin.carService.service.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.service.entity.ServiceEntity;
import ru.shumilin.carService.service.exception.ServiceNotFoundException;
import ru.shumilin.carService.service.repository.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ServiceService {
    private ServiceRepository serviceRepository;

    public List<ServiceEntity> findAll() {
        List<ServiceEntity> result = new ArrayList<>();
        serviceRepository.findAll().forEach(result::add);
        return result;
    }

    @Transactional
    public ServiceEntity update(int id, String name, int price){
        ServiceEntity serviceEntity = findById(id);
        serviceEntity.setName(name);
        serviceEntity.setPrice(price);
        return serviceRepository.save(serviceEntity);
    }

    public ServiceEntity findById(int id){
        return serviceRepository.findById(id).orElseThrow(
                () -> new ServiceNotFoundException(
                        "Сервис с id " + id + " не найден"
                )
        );
    }

    public ServiceEntity findByName(String name){
        return serviceRepository.findByName(name).orElseThrow(
                () -> new ServiceNotFoundException(
                        "Сервис с именем " + name + " не найден"
                )
        );
    }

    public ServiceEntity save(ServiceEntity serviceEntity){
        return serviceRepository.save(serviceEntity);
    }

    public boolean deleteById(int id) {
        serviceRepository.deleteById(id);
        return !serviceRepository.existsById(id);
    }
}
