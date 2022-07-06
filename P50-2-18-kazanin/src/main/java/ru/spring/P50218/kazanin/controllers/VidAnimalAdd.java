package ru.spring.P50218.kazanin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.spring.P50218.kazanin.models.VidAnimal;
import ru.spring.P50218.kazanin.repo.VidAnimalRepository;

@Controller
@RequestMapping("/vidSovet/add")
public class VidAnimalAdd {

    @Autowired
    VidAnimalRepository vidAnimalRepository;

    @GetMapping("/")
    public String show(Model model) {
        return "soveti/vid-add";
    }
    @PostMapping("/")
    public String add(@RequestParam(name = "name")String name,Model model) {
        VidAnimal vid = new VidAnimal();
        vid.setName(name);
        vidAnimalRepository.save(vid);
        return "redirect:/vidSovet/";
    }
}
