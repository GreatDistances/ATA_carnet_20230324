package com.greatdistances.self20230324.controllers;

import model.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tag")
public class TagController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Tag Index");
        return "tag/index";
    }

    @GetMapping("add")
    public String displayAddTagForm(Model model) {
        model.addAttribute("title", "Add Tag");
        model.addAttribute(new Tag()); // TODO MPW - how does this work ??
        return "tag/add";
    }
}
