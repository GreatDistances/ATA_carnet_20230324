package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Department;
import com.greatdistances.self20230324.model.data.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Department Index");
        model.addAttribute("departments", departmentRepository.findAll());
        return "department/index";
    }

    @GetMapping("add")
    public String displayAddCategoryForm(Model model) {
        model.addAttribute("title", "Add Department");
        model.addAttribute(new Department()); // TODO MPW - how does this work ??
        return "department/add";
    }

    @PostMapping("add")
    public String processAddCategoryForm(@ModelAttribute Department newDepartment, Model model) {
        model.addAttribute("title", "Add Department");
        departmentRepository.save(newDepartment);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }
}
