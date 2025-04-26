package ru.shumilin.carService.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @GetMapping
    @RequestMapping("/")
    public String login() {
        return "auth.html";
    }

    @GetMapping
    @RequestMapping("/manager-auth")
    public String auth() {
        return "managerLogin.html";
    }

    @GetMapping
    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }

    @GetMapping
    @RequestMapping("/register")
    public String register() {
        return "register.html";
    }
}
