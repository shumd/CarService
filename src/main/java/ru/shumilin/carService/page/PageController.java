package ru.shumilin.carService.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @GetMapping
    @RequestMapping("/auth")
    public String login() {
        return "auth.html";
    }

    @GetMapping
    @RequestMapping("/manager-auth")
    public String auth() {
        return "managerLogin.html";
    }

    @GetMapping
    @RequestMapping("/profile")
    public String profile() {
        return "profile.html";
    }

    @GetMapping
    @RequestMapping("/manager")
    public String manager() {
        return "managerIndex.html";
    }

    @GetMapping
    @RequestMapping("/manager-requests")
    public String managerRequests() {
        return "managerRequests.html";
    }

    @GetMapping
    @RequestMapping("manager-mechanics")
    public String managerMechanics() {
        return "managerMechanics.html";
    }

    @GetMapping
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping
    @RequestMapping("/register")
    public String register() {
        return "register.html";
    }

    @GetMapping
    @RequestMapping("/admin")
    public String admin() {
        return "admin-index.html";
    }

    @GetMapping
    @RequestMapping("/admin-makers")
    public String adminMakers() {
        return "admin-makers.html";
    }

    @GetMapping
    @RequestMapping("/admin-engine-types")
    public String adminEngineTypes() {
        return "admin-engine-types.html";
    }

    @GetMapping
    @RequestMapping("/admin-service-requests")
    public String adminServiceRequests() {
        return "admin-service-requests.html";
    }

    @GetMapping
    @RequestMapping("/admin-clients")
    public String adminClients() {
        return "admin-clients.html";
    }

    @GetMapping
    @RequestMapping("/admin-managers")
    public String adminManagers() {
        return "admin-managers.html";
    }

    @GetMapping
    @RequestMapping("/admin-mechanics")
    public String adminMechanics() {
        return "admin-mechanics.html";
    }

    @GetMapping
    @RequestMapping("/admin-service-status")
    public String adminServiceStatus() {
        return "admin-service-status.html";
    }

    @GetMapping
    @RequestMapping("/admin-work-status")
    public String adminWorkStatus() {
        return "admin-work-status.html";
    }
}
