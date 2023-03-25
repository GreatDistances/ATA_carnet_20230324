package com.greatdistances.self20230324.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    //private ItemRepository itemRepository;
    //private TagRepository tagRepository;

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Main Index");
        return "index";
    }

}
