package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Item;
import com.greatdistances.self20230324.model.data.CategoryRepository;
import com.greatdistances.self20230324.model.data.ItemRepository;
import com.greatdistances.self20230324.model.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Item Index");
        model.addAttribute("items", itemRepository.findAll());
        return "inventory/index";
    }

    @GetMapping("add")
    public String displayAddItemForm(Model model) {
        model.addAttribute("title", "Add Item");
        //model.addAttribute("items", itemRepository.findAll());
        //model.addAttribute("category", categoryRepository.findAll());
        //model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute(new Item()); // TODO MPW - how does this work ??
        return "inventory/add";
    }

    @PostMapping("add")
    public String processAddItemForm(@ModelAttribute @Valid Item newItem, Model model, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Item");
            model.addAttribute("errorMsg", "Bad data!");
            return "inventory/add";
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
        return "inventory/delete";
    }

    @PostMapping("delete")
    public String processDeleteItemForm(@RequestParam long[] itemIds) {
        for (long id : itemIds) {
            Optional<Item> optItem = itemRepository.findById((int) id);
            if (optItem.isPresent()) {
                itemRepository.deleteById((int) id);
            }
        }
        return "redirect:";
    }

}
