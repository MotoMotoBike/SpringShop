package ru.spring.P50218.kazanin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.spring.P50218.kazanin.models.Poroda;
import ru.spring.P50218.kazanin.models.Role;
import ru.spring.P50218.kazanin.models.User;
import ru.spring.P50218.kazanin.models.VidAnimal;
import ru.spring.P50218.kazanin.repo.PorodaRepository;
import ru.spring.P50218.kazanin.repo.UserRepository;
import ru.spring.P50218.kazanin.repo.VidAnimalRepository;

@Controller
@RequestMapping("/vidSovet")
public class VidSovetSelectController {

    @Autowired
    private VidAnimalRepository vidAnimalRepository;

    @Autowired
    private PorodaRepository porodaRepository;

    @Autowired
    private UserRepository userRepository;

    private String getUserName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((!(auth instanceof AnonymousAuthenticationToken)) && auth != null) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();

            if (userDetail != null) {
                return userDetail.getUsername();
            } else {
                return "";
            }
        }
        return "";
    }
    @GetMapping("/")
    public String vids(Model model) {
        Iterable<VidAnimal> vidAnimalIterableite = vidAnimalRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }
        model.addAttribute("isPost",false);
        model.addAttribute("allvids",vidAnimalIterableite);
        return "soveti/vid-select";
    }

    @PostMapping("/")
    public String openanimals(@RequestParam("vidselect") Long id, Model model) {

        Iterable<VidAnimal> vidAnimals = vidAnimalRepository.findAll();

        User user = userRepository.findByUsername(getUserName());

        model.addAttribute("isAdmin",false);
        model.addAttribute("user",user.getUsername());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }

        Iterable<Poroda> porodas = porodaRepository.findAllByVidAnimalId(id);
        model.addAttribute("porodas",porodas);

        model.addAttribute("id",id);
        model.addAttribute("isPost",true);
        model.addAttribute("allvids", vidAnimals);
        return "soveti/vid-select";
    }
}
