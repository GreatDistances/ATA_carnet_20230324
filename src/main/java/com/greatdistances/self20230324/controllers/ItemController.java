package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Item;
import com.greatdistances.self20230324.model.data.DepartmentRepository;
import com.greatdistances.self20230324.model.data.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Item Index");
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());
        return "item/index";
    }

    @GetMapping("add")
    public String displayAddItemForm(Model model) {
        model.addAttribute("title", "Add Item");
        //model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("departments", departmentRepository.findAll());
        //model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute(new Item()); // TODO MPW - how does this work ??
        return "item/add";
    }

    @PostMapping("add")
    public String processAddItemForm(@Valid @ModelAttribute Item newItem, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            model.addAttribute("errorMsg", "Bad data!");
            return "item/add";
        }

        model.addAttribute("title", "Add Item To Inventory");
        newItem.setValueTotal(newItem.getValuePerPiece(), newItem.getPieces());
        newItem.setWeightKgTotal(newItem.getWeightKgPerPiece(), newItem.getPieces());
        itemRepository.save(newItem);
        //TODO @Valid
        //TODO error handling
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteItemForm(Model model) {
        model.addAttribute("title", "Delete Item(s)");
        model.addAttribute("items", itemRepository.findAll());
        return "item/delete";
    }

    @PostMapping("delete")
    public String processDeleteItemForm(@RequestParam long[] itemIds) {
        for (long id : itemIds) {
            Optional<Item> optItem = itemRepository.findById(id);
            if (optItem.isPresent()) {
                itemRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

}
