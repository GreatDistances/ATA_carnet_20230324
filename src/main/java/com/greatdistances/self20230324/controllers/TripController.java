package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Trip;
import com.greatdistances.self20230324.model.data.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("trip")
public class TripController {

    @Autowired
    TripRepository tripRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Trip Index");
        model.addAttribute("trips", tripRepository.findAll());
        return "trip/index";
    }

    @GetMapping("add")
    public String displayAddTripForm(Model model) {
        model.addAttribute("title", "Add Trip");
        model.addAttribute(new Trip()); // TODO MPW - how does this work ??
        return "trip/add";
    }

    @PostMapping("add")
    public String processAddTripForm(@ModelAttribute @Valid Trip newTrip, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            model.addAttribute("errorMsg", "Bad data!");
            return "inventory/add";
        }

        model.addAttribute("title", "Add Item");
        tripRepository.save(newTrip);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteTripForm(Model model) {
        model.addAttribute("title", "Delete Trip(s)");
        model.addAttribute("trips", tripRepository.findAll());
        return "trip/delete";
    }

    @PostMapping("delete")
    public String processDeleteTripForm(@RequestParam int[] tripIds) {
        for (int id : tripIds) {
            Optional<Trip> optTrip = tripRepository.findById(id);
            if (optTrip.isPresent()) {
                tripRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{tripId}")
    public String displayEditTripForm(Model model, @PathVariable int tripId) {

        Optional<Trip> optTrip = tripRepository.findById(tripId);
        if (optTrip.isEmpty()) {
            return "trip/index";
        }

        model.addAttribute("title", "Edit Trip, ID #" + tripId);
        model.addAttribute("trip", optTrip.get());
        return "trip/edit";
    }

    @PutMapping("edit")
    public String processEditTripForm(@PathVariable(value="tripId"), int id,  {

        tripRepository.save(thisTrip);
    }

}
