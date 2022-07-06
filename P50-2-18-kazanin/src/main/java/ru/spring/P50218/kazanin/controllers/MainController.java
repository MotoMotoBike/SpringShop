package ru.spring.P50218.kazanin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String hello(Model model) {
        return "home";
    }
    @GetMapping("/home")
    public String home(Model model){
        return "home";
    }
}
