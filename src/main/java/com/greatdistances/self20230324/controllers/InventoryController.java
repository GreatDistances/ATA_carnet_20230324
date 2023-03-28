package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Item;
import com.greatdistances.self20230324.model.data.CategoryRepository;
import com.greatdistances.self20230324.model.data.ItemRepository;
import com.greatdistances.self20230324.model.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("category", categoryRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute(new Item()); // TODO MPW - how does this work ??
        return "inventory/add";
    }

    @PostMapping("add")
    public String processAddItemForm(@Valid @ModelAttribute Item newItem, Model model) {
        model.addAttribute("title", "Add Item To Inventory");
        itemRepository.save(newItem);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }

}
