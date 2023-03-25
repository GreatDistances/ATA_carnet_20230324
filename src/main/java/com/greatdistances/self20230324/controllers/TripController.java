package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Trip;
import com.greatdistances.self20230324.model.data.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("trip")
public class TripController {

    @Autowired
    TripRepository tripRepository;

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

    @PostMapping("add")
    public String processAddTripForm(@ModelAttribute Trip newTrip, Model model) {
        model.addAttribute("title", "Add Trip");
        tripRepository.save(newTrip);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }

}
