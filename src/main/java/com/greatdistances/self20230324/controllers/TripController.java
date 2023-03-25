package com.greatdistances.self20230324.controllers;

import model.Trip;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("trip")
public class TripController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Trip Index");
        return "trip/index";
    }

    @GetMapping("add")
    public String displayAddTripForm(Model model) {
        model.addAttribute("title", "Add Trip");
        model.addAttribute(new Trip()); // TODO MPW - how does this work ??
        return "trip/add";
    }

}
