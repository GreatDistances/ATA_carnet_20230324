package com.greatdistances.self20230324.controllers;

import model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("item")
public class ItemController {

    //@Autowired
    //ItemRepository itemRepository;
    //@Autowired
    //TagRepository tagRepository;
    //@Autowired
    //CategoryRepository categoryRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Item Index");
        return "item/index";
    }
    @GetMapping("add")
    public String displayAddItemForm(Model model) {
        model.addAttribute("title", "Add Item");
        //model.addAttribute("items", itemRepository.findAll());
        //model.addAttribute("category", categoryRepository.findAll());
        //model.addAttribute("tags", tagRepository.findAll());
        model.addAttribute(new Item()); // TODO MPW - how does this work ??
        return "item/add";
    }

    @PostMapping("add")
    public String processAddItemForm(Model model, @ModelAttribute Item newItem) {
        model.addAttribute("title", "Add Item");
        //itemRepository.save(newItem);
        //TODO @Valid, error handling
        return "redirect:";
    }

}
