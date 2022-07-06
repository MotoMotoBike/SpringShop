package ru.spring.P50218.kazanin.controllers;

import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.P50218.kazanin.models.*;
import ru.spring.P50218.kazanin.repo.ImageRepository;
import ru.spring.P50218.kazanin.repo.PorodaRepository;
import ru.spring.P50218.kazanin.repo.SovetPoUhodyRepository;
import ru.spring.P50218.kazanin.repo.UserRepository;

@Controller
@RequestMapping("/animal")
public class showSovetsController {
    @Autowired
    private PorodaRepository porodaRepository;
    @Autowired
    private SovetPoUhodyRepository sovetPoUhodyRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ImageRepository imageRepository;
    @Autowired
    SovetPoUhodyRepository sovetRepository;

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

    @GetMapping("{id}/add") //добавление совета страница
    public String sovetaddview(@PathVariable(value = "id")Long id_porodi, Model model) {
        return "soveti/sovet-add";
    }

    @PostMapping("{id}/add") //добавление совета страница
    public String sovetadd(
            @RequestParam(name = "url")     String url,
            @RequestParam(name = "header")  String header,
            @RequestParam(name = "text")    String text,
            @PathVariable(value = "id") Long id_porodi
            , Model model) {

        if(!url.equals("")&&!header.equals("")&&!text.equals("")){
            Image img = new Image();
            img.setUrl(url);
            imageRepository.save(img);

            SovetPoUhody sovet = new SovetPoUhody();
            sovet.setImageSovet(imageRepository.findByUrl(url));
            sovet.setHeader(header);
            sovet.setText(text);

            Poroda poroda = porodaRepository.findFirstById(id_porodi);
            sovet.setPoroda(poroda);

            sovetRepository.save(sovet);
            model.addAttribute("ok","Все значения введены корректно, запись опубликована");
            return "soveti/sovet-add";
        }else {
            model.addAttribute("err","Не все значения введены корректно");
        }

        return "soveti/sovet-add";
    }



    @GetMapping("/{id}") //выбор совета
    public String sovetsall(@PathVariable(value = "id")Long id_porodi, Model model) {

        User user = userRepository.findByUsername(getUserName());
        for(var i : user.getRoles()) {
            if(i.equals(Role.ADMIN)) model.addAttribute("isAdmin",true);
        }

        Iterable<SovetPoUhody> soveti = sovetPoUhodyRepository.findAllByPorodaId(id_porodi);

        model.addAttribute("idporodi",id_porodi);
        model.addAttribute("soveti",soveti);
        return "soveti/soveti-po-uhodu-view";
    }
    @GetMapping("/{id}/view")  //совет
    public String sovetview(@PathVariable(value = "id")Long id_soveta, Model model) {
        SovetPoUhody sovet = sovetPoUhodyRepository.findFirstById(id_soveta);
        model.addAttribute("sovet",sovet);
        return "soveti/sovet-view";
    }
}
