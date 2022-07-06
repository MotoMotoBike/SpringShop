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

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {
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
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    KategoryRepository kategoryRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    VidAnimalRepository vidAnimalRepository;
    @Autowired
    TovarRepository tovarRepository;

    @GetMapping("/")
    public String all( Model model) {
        Iterable<News> allnews = newsRepository.findAll();
        Iterable<Kategory> allkategory = kategoryRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }

        model.addAttribute("allnews",allnews);
        model.addAttribute("allkategory",allkategory);
        return "news/news-all-view";
    }
    @PostMapping("/")
    public String filter(@RequestParam(value = "kategory") Long id_kategory,Model model) {
        Iterable<News> allnews = newsRepository.findAllByKategoryId(id_kategory);
        Iterable<Kategory> allkategory = kategoryRepository.findAll();
        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }

        model.addAttribute("allnews",allnews);
        model.addAttribute("allkategory",allkategory);
        return "news/news-all-view";
    }
    @GetMapping("/add")
    public String addview(Model model) {
        Iterable<Kategory> allkategory = kategoryRepository.findAll();
        model.addAttribute("allkategory",allkategory);
        return "news/news-add";
    }
    @PostMapping("/add")
    public String add(
            @RequestParam(name = "url")     String url,
            @RequestParam(name = "header")  String header,
            @RequestParam(name = "text")    String text,
            @RequestParam(name = "kategoryselect") Long id_kategory,
            Model model) {
        Iterable<Kategory> allkategory = kategoryRepository.findAll();
        model.addAttribute("allkategory",allkategory);
        if(url.equals("") || header.equals("")|| text.equals(""))
        {
            model.addAttribute("err","Пропущены поля новость не опубликована");
        }
        else
        {
            Image img = new Image();
            img.setUrl(url);
            imageRepository.save(img);

            Kategory kategory = kategoryRepository.findFirstById(id_kategory);

            News news = new News();
            news.setDate(new Date());
            news.setImageNews(img);
            news.setHeader(header);
            news.setText(text);
            news.setKategory(kategory);

            newsRepository.save(news);

            model.addAttribute("ok","Новость опубликована");
        }
        return "news/news-add";
    }
    @GetMapping("/view/{id}")
    public String openview(
            @PathVariable(name = "id") Long id,
            Model model) {
        News news =  newsRepository.findFirstById(id);

        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }
        model.addAttribute("news",news);
        return "news/news-view";
    }
    @GetMapping("/view/{id}/addTovar")
    public String addTovarView(@PathVariable(name = "id") Long id,Model model){
        News news =  newsRepository.findFirstById(id);
        Iterable<Tovar> alltovars = tovarRepository.findAll();
        model.addAttribute("news",news);
        model.addAttribute("alltovars", alltovars);
        return "news/news-addTovar";
    }
    @PostMapping("/view/{id}/addTovar")
    public String addTovar(@PathVariable(name = "id") Long id_news,
                           @RequestParam(value = "tovarselect") Long id_tovar,
                           Model model){
        News news =  newsRepository.findFirstById(id_news);
        Tovar findTovar = tovarRepository.findFirstById(id_tovar);
        Iterable<Tovar> alltovars = tovarRepository.findAll();

        List<Tovar> addetTovars = news.getTovars();

        addetTovars.add(findTovar);

        news.setTovars(addetTovars);

        newsRepository.save(news);

        model.addAttribute("news",news);
        model.addAttribute("alltovars", alltovars);
        return "news/news-addTovar";
    }
}
