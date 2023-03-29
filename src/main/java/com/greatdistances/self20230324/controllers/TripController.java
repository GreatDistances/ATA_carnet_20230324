package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Trip;
import com.greatdistances.self20230324.model.data.TripRepository;
import com.greatdistances.self20230324.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("trip")
public class TripController {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    TripService tripService;

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
    public String processDeleteTripForm(@RequestParam long[] tripIds) {
        for (long id : tripIds) {
            Optional<Trip> optTrip = tripRepository.findById((int) id);
            if (optTrip.isPresent()) {
                tripRepository.deleteById((int) id);
            }
        }
        return "redirect:";
    }


/*@GetMapping("edit/{tripId}")
    public String displayEditTripForm(Model model, @PathVariable int tripId) {

        Optional<Trip> optTrip = tripRepository.findById(tripId);
        if (optTrip.isEmpty()) {
            return "trip/index";
        }

        model.addAttribute("title", "Edit Trip, ID #" + tripId);
        model.addAttribute("trip", optTrip.get());
        return "trip/edit";
    }

    @PutMapping("edit/{tripId}")
    public ResponseEntity<Trip> updateTrip(@PathVariable int tripId,@RequestBody Trip trip) {
        Trip updateTrip = tripRepository.findById(tripId)
                .orElseThrow(() -> new Error("Employee not exist with id: " + tripId));

        updateTrip.setCountry(trip.getCountry());
        updateTrip.setJobNumber(trip.getJobNumber());

        tripRepository.save(updateTrip);

        return ResponseEntity.ok(updateTrip);
    }*/


}
