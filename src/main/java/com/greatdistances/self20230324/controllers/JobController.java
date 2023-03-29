package com.greatdistances.self20230324.controllers;

import com.greatdistances.self20230324.model.Job;
import com.greatdistances.self20230324.model.data.JobRepository;
import com.greatdistances.self20230324.model.data.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("job")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private TripRepository tripRepository;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("title", "Job Index");
        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("trips", tripRepository.findAll());
        return "job/index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job()); // TODO MPW - how does this work ??
        return "job/add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute Job newJob, Model model) {
        model.addAttribute("title", "Add Department");
        jobRepository.save(newJob);
        //TODO @Valid
        // TODO error handling
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteJobForm(Model model) {
        model.addAttribute("title", "Delete Job(s)");
        model.addAttribute("jobs", jobRepository.findAll());
        return "job/delete";
    }

    @PostMapping("delete")
    public String processDeleteJobForm(@RequestParam long[] jobIds) {
        for (long id : jobIds) {
            Optional<Job> optJob = jobRepository.findById(id);
            if (optJob.isPresent()) {
                jobRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
