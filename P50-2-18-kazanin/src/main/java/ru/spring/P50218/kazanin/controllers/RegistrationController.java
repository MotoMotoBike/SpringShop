package ru.spring.P50218.kazanin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.spring.P50218.kazanin.models.Role;
import ru.spring.P50218.kazanin.models.User;
import ru.spring.P50218.kazanin.repo.UserRepository;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String regview(){
        return "registration";
    }
    @PostMapping("/registration")
    public String reg(User user, Model model){
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if( userFromDB != null){
            //model.addAttribute("error","Пользователь с таким логином существует");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }
}
