package ru.spring.P50218.kazanin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.P50218.kazanin.models.*;
import ru.spring.P50218.kazanin.repo.*;

@Controller
@RequestMapping("/tovari")
public class tovariController {

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    TovarRepository tovarRepository;
    @Autowired
    VidAnimalRepository vidAnimalRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChartRepository chartRepository;
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
    public String all( Model model) {
        Iterable<Tovar> alltovari = tovarRepository.findAll();
        Iterable<VidAnimal> allvids = vidAnimalRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }

        model.addAttribute("alltovari",alltovari);
        model.addAttribute("allvids",allvids);
        return "tovari/tovari-list-view";
    }
    @PostMapping("/")
    public String filter(@RequestParam(value = "vid") Long id_vida, Model model) {
        Iterable<Tovar> alltovari = tovarRepository.findAllByVidAnimalId(id_vida);
        Iterable<VidAnimal> allvids = vidAnimalRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }
        model.addAttribute("alltovari",alltovari);
        model.addAttribute("allvids",allvids);
        return "tovari/tovari-list-view";
    }
    @GetMapping("/add")
    public String addview( Model model) {

        Iterable<VidAnimal> allvids = vidAnimalRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }
        model.addAttribute("allvids",allvids);

        return "tovari/tovar-add";
    }
    @PostMapping("/add")
    public String add(
            @RequestParam(name = "url")         String url,
            @RequestParam(name = "name")        String name,
            @RequestParam(name = "discription") String discription,
            @RequestParam(name = "vid")         Long id_vid,
            @RequestParam(name = "count")       Integer count,
            @RequestParam(name = "cost")        Integer cost,
            Model model) {
        Iterable<VidAnimal> allvids = vidAnimalRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }
        if(url.equals("") || name.equals("")|| discription.equals("") || cost.equals("") ||count.equals(""))
        {
            model.addAttribute("err","Пропущены поля новость не опубликована");
        }else
        {
            Image img = new Image();
            img.setUrl(url);
            imageRepository.save(img);

            VidAnimal vid = vidAnimalRepository.findFirstById(id_vid);
            Tovar tovar = new Tovar();
            tovar.setImageTovar(img);
            tovar.setName(name);
            tovar.setDiscription(discription);
            tovar.setVidAnimal(vid);
            tovar.setCount(count);
            tovar.setCost(cost);

            tovarRepository.save(tovar);

            model.addAttribute("ok","Новость опубликована");
        }
        model.addAttribute("allvids",allvids);
        return "tovari/tovar-add";
    }
    @GetMapping("/view/{id}")
    public String openview(
            @PathVariable(name = "id") Long id_tovara,
            Model model) {
        Tovar tovar =  tovarRepository.findFirstById(id_tovara);
        model.addAttribute("tovar",tovar);
        return "tovari/tovar-view";
    }

    @GetMapping("/{id}/addToChart")
    public String addToChart(
            @PathVariable(name = "id") Long id_tovara,
            Model model) {
        Tovar tovar =  tovarRepository.findFirstById(id_tovara);
        if(tovar.getCount() > 0){
            User user = userRepository.findByUsername(getUserName());
            Chart chart = new Chart();
            chart.setUser(user);
            chart.setTovar(tovar);
            chart.setCount(1);
            chartRepository.save(chart);
        }
        Iterable<Tovar> alltovari = tovarRepository.findAll();
        Iterable<VidAnimal> allvids = vidAnimalRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }
        model.addAttribute("alltovari",alltovari);
        model.addAttribute("allvids",allvids);
        return "tovari/tovari-list-view";
    }
}
