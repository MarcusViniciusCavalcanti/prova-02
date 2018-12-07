package br.edu.utfpr.tsi.prova02.controller;

import br.edu.utfpr.tsi.prova02.domain.entity.Candidate;
import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
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

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public ModelAndView getAll() {
        List<Job> jobs = jobService.findAll();
        ModelAndView modelAndView = new ModelAndView("/jobs/index");
        modelAndView.addObject("jobs", jobs);
        return modelAndView;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/novo")
    public ModelAndView newJob(@ModelAttribute("job") Job job, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView("/jobs/form");
        modelAndView.addObject("action", "Cadastrar");
        modelAndView.addObject("title", "Nova Vaga");
        return modelAndView;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
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

    @PreAuthorize("hasAnyRole('ADMIN')")
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

    @PreAuthorize("hasAnyRole('ADMIN')")
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

    @PreAuthorize("hasAnyRole('ADMIN')")
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

    @GetMapping("/candidatar/{id}")
    public ModelAndView candidateAdd(@PathVariable("id") Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        Candidate candidate = (Candidate) session.getAttribute("candidate");
        try {
            jobService.candidateAdd(candidate, id);
            redirectAttributes.addFlashAttribute("success", "Candidatura registrada com sucesso");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Não foi possível adicionar a vaga");
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/candidato/dashboard");
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/candidatos/{id}")
    public ModelAndView candidates(@PathVariable("id") Long id) {
        Job job = jobService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/jobs/jobs_candidates");
        modelAndView.addObject("candidates", job.getCandidates());
        return modelAndView;
    }
}
