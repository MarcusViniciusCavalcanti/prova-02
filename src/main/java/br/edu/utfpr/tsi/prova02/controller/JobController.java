package br.edu.utfpr.tsi.prova02.controller;

import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/vagas")
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

    @GetMapping("/novo")
    public ModelAndView newJob(@ModelAttribute("job") Job job, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("/jobs/form");
        modelAndView.addObject("action", "Cadastrar");
        modelAndView.addObject("title", "Nova Vaga");
        return modelAndView;
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView update(@PathVariable("id") Long id, ModelMap modelMap, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView;
        try {
            Job job = jobService.findById(id);
            modelAndView = new ModelAndView("/jobs/form");
            modelAndView.addObject("action", "Atualizar");
            modelAndView.addObject("title", "Atualizar Vaga: " + job.getTitle());
            modelMap.addAttribute("job", job);
            modelAndView.addObject(modelMap);
        } catch (EntityNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            modelAndView = new ModelAndView("redirect:/vagas");
        }
        return modelAndView;
    }

    @GetMapping("deletar/{id}")
    public ModelAndView delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            jobService.deleteById(id);
            redirectAttributes.addFlashAttribute("success", "Vaga deletada com sucesso");
        } catch (EmptyResultDataAccessException e) {
            redirectAttributes.addFlashAttribute("error", "Error ao deletar a vaga!");
        }
        return new ModelAndView("redirect:/vagas");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute("job") Job job, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("/jobs/form");
        }

        try {
            jobService.save(job);
            redirectAttributes.addFlashAttribute("success", "Vaga criada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Não foi possivel salvar a vaga!");
        }
        return new ModelAndView("redirect:/vagas/novo");
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("job") Job job, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("/jobs/form");
        }
        try {
            jobService.save(job);
            redirectAttributes.addFlashAttribute("success", "Vaga Editada com sucesso");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ocorreu um erro na edição da vaga!");
        }
        return new ModelAndView("redirect:/vagas");
    }
}
