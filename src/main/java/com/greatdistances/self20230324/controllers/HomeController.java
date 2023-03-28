package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.data.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private TripRepository tripRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Main Index");
        model.addAttribute("trips", tripRepository.findAll());
        return "index";
    }

}
