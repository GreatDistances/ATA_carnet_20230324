package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Tag;
import com.greatdistances.self20230324.model.data.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tags")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Tag Index");
        return "tag/index";
    }

    @GetMapping("add")
    public String displayAddItemForm(Model model) {
        model.addAttribute("title", "Add Tag");
        model.addAttribute(new Tag()); // TODO MPW - how does this work ??
        return "tags/add";
    }

    @PostMapping("add")
    public String processAddTagForm(@ModelAttribute Tag newTag, Model model) {
        model.addAttribute("title", "Add Tag");
        tagRepository.save(newTag);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }
}
