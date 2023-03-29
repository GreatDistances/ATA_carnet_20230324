package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Equiplist;
import com.greatdistances.self20230324.model.data.EquiplistRepository;
import com.greatdistances.self20230324.model.data.ItemRepository;
import com.greatdistances.self20230324.model.data.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("equiplist")
public class EquiplistController {

    @Autowired
    private EquiplistRepository equiplistRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("title", "Equipment List Index");
        model.addAttribute("equiplists", equiplistRepository.findAll());
        return "equiplist/index";
    }

    @GetMapping("add")
    public String displayNewEquipListForm(Model model) {
        model.addAttribute("title", "New Equipment List");
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute(new Equiplist()); // TODO MPW - how does this work ??
        return "equiplist/add";
    }

    @PostMapping("add")
    public String processNewEquipListForm(@ModelAttribute @Valid Equiplist newEquiplist, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "New Equipment List");
            model.addAttribute("errorMsg", "Bad data!");
            return "equiplist/add";
        }

        model.addAttribute("title", "New Equipment List");
        equiplistRepository.save(newEquiplist);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteItemForm(Model model) {
        model.addAttribute("title", "Delete Item(s)");
        model.addAttribute("equiplists", equiplistRepository.findAll());
        return "equiplist/delete";
    }

    @PostMapping("delete")
    public String processDeleteItemForm(@RequestParam long[] equiplistIds) {
        for (long id : equiplistIds) {
            Optional<Equiplist> optEquiplist = equiplistRepository.findById(id);
            if (optEquiplist.isPresent()) {
                equiplistRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
