package ru.shumilin.carService.human.client.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.shumilin.carService.car.entity.CarEntity;
import ru.shumilin.carService.human.client.entity.ClientEntity;
import ru.shumilin.carService.human.client.exception.ClientNotFoundException;
import ru.shumilin.carService.human.client.request.ClientRequest;
import ru.shumilin.carService.human.client.service.ClientService;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @PostMapping
    public ClientEntity saveClient(@RequestBody ClientRequest clientRequest) {
        return clientService.save(clientService.toEntity(clientRequest));
    }

    @GetMapping("/car/{id}")
    public List<CarEntity> getClientsCars(@PathVariable int id) {
        return clientService.getCarsById(id);
    }

    @DeleteMapping
    public boolean deleteClientById(@RequestParam int id) {
        return clientService.deleteById(id);
    }

    @GetMapping("/all")
    public List<ClientEntity> getAllClients() {
        return clientService.findAll();
    }
    @GetMapping("/phone")
    public ClientEntity getClientByPhoneNumber(@RequestParam String phone) {
        return clientService.findByPhone(phone);
    }
    @GetMapping("/id")
    public ClientEntity getClientById(@RequestParam int id) {
        return clientService.findById(id);
    }

    @PostMapping("/car")
    public CarEntity addCar(@RequestParam String licensePlate, @RequestParam int clientId) {
        return clientService.addCar(licensePlate, clientId);
    }

    @GetMapping("/auth")
    public boolean auth(@RequestParam String phoneNumber, @RequestParam String password, HttpSession session) {
        if (clientService.login(phoneNumber, password)){
            session.setAttribute("phoneNumber", phoneNumber);
            return true;
        }
        return false;
    }

    @GetMapping("/profile")
    public ClientEntity profile(HttpSession session) {
        try {
            return clientService.findByPhone((String) session.getAttribute("phoneNumber"));
        } catch (ClientNotFoundException e) {
            throw new RuntimeException("session is null");
        }
    }

    @PostMapping("/logout")
    public boolean logout(HttpSession session) {
        session.removeAttribute("client");
        return true;
    }
}
