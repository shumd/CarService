package ru.shumilin.carService.human.client.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.shumilin.carService.car.entity.CarEntity;
import ru.shumilin.carService.car.service.CarService;
import ru.shumilin.carService.human.client.entity.ClientEntity;
import ru.shumilin.carService.human.client.exception.ClientNotFoundException;
import ru.shumilin.carService.human.client.repository.ClientRepository;
import ru.shumilin.carService.human.client.request.ClientRequest;
import ru.shumilin.carService.human.name.entity.NameEntity;
import ru.shumilin.carService.human.name.service.NameService;


import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class ClientService {
    private final ClientRepository clientRepository;
    private final NameService nameService;
    private final CarService carService;

    public boolean deleteById(int id){
        clientRepository.deleteById(id);
        return !clientRepository.existsById(id);
    }

    public List<ClientEntity> findAll(){
        List<ClientEntity> clientEntities = new ArrayList<>();
        clientRepository.findAll().forEach(clientEntities::add);
        return clientEntities;
    }

    public List<CarEntity> getCarsById(int id){
        return findById(id).getCarEntities().stream().peek(System.out::println).toList();
    }

    public ClientEntity findById(int id){
        return clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException(
                        "Клиент с id " + id + " не найден"
                )
        );
    }
    public ClientEntity findByPhone(String phone){
        return clientRepository.findByPhoneNumber(phone).orElseThrow(
                () -> new ClientNotFoundException(
                        "Клиент с номер " + phone + " не найден"
                )
        );
    }
    public ClientEntity save(ClientEntity clientEntity){
        return clientRepository.save(clientEntity);
    }
    public boolean login(String phoneNumber, String password){
        ClientEntity client = clientRepository.findByPhoneNumber(phoneNumber).orElseThrow(
                () -> new ClientNotFoundException(
                        "Клиент с телефоном " + phoneNumber + " не найден"
                )
        );
        return client.getPhoneNumber().equals(phoneNumber) &&
                client.getPassword().equals(password);
    }

    @Transactional
    public CarEntity addCar(String licensePlate, int clientId){
        CarEntity carEntity = carService.findByLicensePlate(licensePlate);
        ClientEntity clientEntity = findById(clientId);
        clientEntity.addCar(carEntity);
        return carEntity;
    }

    public ClientEntity toEntity(ClientRequest clientRequest) {
        NameEntity nameEntity = NameEntity.builder()
                .name(clientRequest.getName())
                .patronymic(clientRequest.getPatronymic())
                .surname(clientRequest.getSurname())
                .build();

        return ClientEntity.builder()
                .name(nameService.save(nameEntity))
                .phoneNumber(clientRequest.getPhone())
                .password(clientRequest.getPassword())
                .build();
    }
}
