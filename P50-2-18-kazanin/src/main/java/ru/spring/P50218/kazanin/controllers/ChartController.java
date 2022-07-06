package ru.spring.P50218.kazanin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.spring.P50218.kazanin.models.*;
import ru.spring.P50218.kazanin.repo.ChartRepository;
import ru.spring.P50218.kazanin.repo.TovarRepository;
import ru.spring.P50218.kazanin.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ChartRepository chartRepository;
    @Autowired
    TovarRepository tovarRepository;

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
        List<Tovar> allTovars = new ArrayList<Tovar>();
        User user = userRepository.findByUsername(getUserName());
        int total = 0;
        Iterable<Chart> allChart = chartRepository.findAllByUserId(user.getId());
        for (var i : allChart) {
            allTovars.add(tovarRepository.findFirstById(i.getTovar().getId()));
        }
        for (var i : allChart) {
            total += i.getTovar().getCost() * i.getCount();
        }
        model.addAttribute("total",total);
        model.addAttribute("allChart",allChart);
        model.addAttribute("allTovars",allTovars);
        return "chart/chart-all-view";
    }

    @GetMapping("/{id}/add")
    public String add(@PathVariable(value = "id") Long id_chart, Model model) {
        List<Tovar> allTovars = new ArrayList<Tovar>();
        User user = userRepository.findByUsername(getUserName());
        Iterable<Chart> allChart = chartRepository.findAllByUserId(user.getId());
        int total = 0;
        for (var i : allChart) {
            allTovars.add(tovarRepository.findFirstById(i.getTovar().getId()));
        }
        Chart added = chartRepository.findFirstById(id_chart);

        if (added.getCount() < added.getTovar().getCount()){
            added.setCount(added.getCount()+1);
        }
        chartRepository.save(added);

        for (var i : allChart) {
            total += i.getTovar().getCost() * i.getCount();
        }
        model.addAttribute("total",total);
        model.addAttribute("allChart",allChart);
        model.addAttribute("allTovars",allTovars);
        return "chart/chart-all-view";
    }
    @GetMapping("/{id}/sub")
    public String sub(@PathVariable(value = "id") Long id_chart, Model model) {
        List<Tovar> allTovars = new ArrayList<Tovar>();
        User user = userRepository.findByUsername(getUserName());
        Iterable<Chart> allChart = chartRepository.findAllByUserId(user.getId());
        int total = 0;
        for (var i : allChart) {
            allTovars.add(tovarRepository.findFirstById(i.getTovar().getId()));
        }
        Chart subed = chartRepository.findFirstById(id_chart);

        if (subed.getCount() > 1){
            subed.setCount(subed.getCount()-1);
        }

        chartRepository.save(subed);

        for (var i : allChart) {
            total += i.getTovar().getCost() * i.getCount();
        }
        model.addAttribute("total",total);
        model.addAttribute("allChart",allChart);
        model.addAttribute("allTovars",allTovars);
        return "chart/chart-all-view";
    }
    @GetMapping("/{id}/del")
    public String del(@PathVariable(value = "id") Long id_chart, Model model) {
        List<Tovar> allTovars = new ArrayList<Tovar>();
        User user = userRepository.findByUsername(getUserName());
        Iterable<Chart> allChart = chartRepository.findAllByUserId(user.getId());

        int total = 0;
        for (var i : allChart) {
            allTovars.add(tovarRepository.findFirstById(i.getTovar().getId()));
        }
        Chart deled = chartRepository.findFirstById(id_chart);
        deled.setCount(0);
        chartRepository.save(deled);

        allChart = chartRepository.findAllByUserId(user.getId());

        for (var i : allChart) {
            total += i.getTovar().getCost() * i.getCount();
        }

        model.addAttribute("total",total);
        model.addAttribute("allChart",allChart);
        model.addAttribute("allTovars",allTovars);
        return "chart/chart-all-view";
    }

    @GetMapping("/buy")
    public String buy(Model model) {
        List<Tovar> allTovars = new ArrayList<Tovar>();
        User user = userRepository.findByUsername(getUserName());
        Iterable<Chart> allChart = chartRepository.findAllByUserId(user.getId());

        int total = 0;
        for (var i : allChart) {
            allTovars.add(tovarRepository.findFirstById(i.getTovar().getId()));
        }
        for (var i : allChart) {
            Tovar tovar = i.getTovar();
            tovar.setCount(tovar.getCount() - i.getCount());
            i.setCount(0);
            tovarRepository.save(tovar);
        }

        allChart = chartRepository.findAllByUserId(user.getId());

        for (var i : allChart) {
            total += i.getTovar().getCost() * i.getCount();
        }

        model.addAttribute("total",total);
        model.addAttribute("allChart",allChart);
        model.addAttribute("allTovars",allTovars);
        return "chart/chart-all-view";
    }

}
