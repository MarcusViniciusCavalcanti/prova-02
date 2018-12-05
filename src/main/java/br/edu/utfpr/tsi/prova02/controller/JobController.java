package br.edu.utfpr.tsi.prova02.controller;

import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ModelAndView getAll() {
        List<Job> jobs = jobService.findAll();
        ModelAndView modelAndView = new ModelAndView("/jobs/index");
        modelAndView.addObject("jobs", jobs);
        return modelAndView;
    }
}
