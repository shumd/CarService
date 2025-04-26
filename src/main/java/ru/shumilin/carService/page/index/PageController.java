package ru.shumilin.carService.page.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @GetMapping
    @RequestMapping("/")
    public String auth() {
        return "login.html";
    }

    @GetMapping
    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }
}
