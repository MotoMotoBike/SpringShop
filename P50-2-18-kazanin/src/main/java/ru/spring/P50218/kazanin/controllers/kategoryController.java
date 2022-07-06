package ru.spring.P50218.kazanin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.spring.P50218.kazanin.models.Kategory;
import ru.spring.P50218.kazanin.models.News;
import ru.spring.P50218.kazanin.models.Role;
import ru.spring.P50218.kazanin.models.User;
import ru.spring.P50218.kazanin.repo.KategoryRepository;

@Controller
@RequestMapping("/news/kategory-add")
public class kategoryController {

    @Autowired
    KategoryRepository kategoryRepository;
    @GetMapping("/")
    public String vids(Model model) {
        return "news/kategory-add";
    }

    @PostMapping("/")
    public String vidsadd(@RequestParam(name = "name") String name, Model model) {
        Kategory kategory = new Kategory();
        if (!name.equals(null))
        {
            kategory.setName(name);
            kategoryRepository.save(kategory);
            model.addAttribute("ok","Категория опубликована");
        }
        else {
            model.addAttribute("err","Поле пустое");
        }
        return "news/kategory-add";
    }
}
