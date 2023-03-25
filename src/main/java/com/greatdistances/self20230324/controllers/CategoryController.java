package com.greatdistances.self20230324.controllers;

import model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Category Index");
        return "category/index";
    }

    @GetMapping("add")
    public String displayAddCategoryForm(Model model) {
        model.addAttribute("title", "Add Category");
        model.addAttribute(new Category()); // TODO MPW - how does this work ??
        return "category/add";
    }
}
