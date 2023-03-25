package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Category;
import com.greatdistances.self20230324.model.data.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("category")
public class CategoryController {

    CategoryRepository categoryRepository;

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

    @PostMapping("add")
    public String processAddCategoryForm(@ModelAttribute Category newCategory, Model model) {
        model.addAttribute("title", "Add Category");
        categoryRepository.save(newCategory);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }
}
