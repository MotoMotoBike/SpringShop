package ru.spring.P50218.kazanin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.P50218.kazanin.models.Poroda;
import ru.spring.P50218.kazanin.models.VidAnimal;
import ru.spring.P50218.kazanin.repo.PorodaRepository;
import ru.spring.P50218.kazanin.repo.VidAnimalRepository;

@Controller
@RequestMapping("/poroda/add")
public class PorodaAddController {
        @Autowired
        VidAnimalRepository vidAnimalRepository;
        @Autowired
        PorodaRepository porodaRepository;
        @GetMapping("/")
        public String show(Model model) {
            Iterable<VidAnimal> vidAnimalIterableite = vidAnimalRepository.findAll();
            model.addAttribute("allvids",vidAnimalIterableite);
            return "soveti/poroda-add";
        }
        @PostMapping("/")
        public String add(
                @RequestParam(name = "name")     String name,
                @RequestParam(name = "vidselect")Long id,
                Model model) {
            if(!name.equals("")){
                Poroda poroda = new Poroda();
                poroda.setName(name);
                VidAnimal vid = vidAnimalRepository.findFirstById(id);
                poroda.setVidAnimal(vid);
                porodaRepository.save(poroda);
            }else {
                model.addAttribute("err","Пропущено поле порода");
            }

            return "redirect:/vidSovet/";
        }

}
