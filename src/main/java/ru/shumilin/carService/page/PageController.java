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
}
