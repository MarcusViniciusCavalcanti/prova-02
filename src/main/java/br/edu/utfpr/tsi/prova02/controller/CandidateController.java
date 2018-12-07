package br.edu.utfpr.tsi.prova02.controller;

import br.edu.utfpr.tsi.prova02.domain.entity.Candidate;
import br.edu.utfpr.tsi.prova02.domain.entity.Job;
import br.edu.utfpr.tsi.prova02.domain.entity.UserDetailsImp;
import br.edu.utfpr.tsi.prova02.domain.service.CandidateService;
import br.edu.utfpr.tsi.prova02.domain.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/candidato")
public class CandidateController {
    private final CandidateService candidateService;
    private final JobService jobService;

    @Autowired
    public CandidateController(CandidateService candidateService, JobService jobService) {
        this.candidateService = candidateService;
        this.jobService = jobService;
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboardCandidate(HttpSession session) {
        UserDetailsImp user = (UserDetailsImp) session.getAttribute("user");
        Long id = user.getId();
        Candidate candidate = candidateService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/candidate/dashboard");
        List<Job> jobs = jobService.findAll();
        modelAndView.addObject("candidate", candidate);
        modelAndView.addObject("jobs",jobs);
        return modelAndView;
    }

    @GetMapping("/atualizar")
    public ModelAndView update(HttpSession session, ModelMap modelMap) {
        Candidate candidate = (Candidate) session.getAttribute("candidate");
        modelMap.addAttribute("candidate", candidate);
        return new ModelAndView("/candidate/form", modelMap);
    }

    @PostMapping("/atualizar")
    public ModelAndView save(@Valid @ModelAttribute("candidate") Candidate candidate, HttpSession session, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("/candidate/form");
        }

        try {
            Candidate current = (Candidate) session.getAttribute("candidate");
            candidate.setId(current.getId());
            session.setAttribute("candidate", candidateService.save(candidate));
            redirectAttributes.addFlashAttribute("success", "Perfil Editada com sucesso");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ocorreu um erro na edição da vaga!");
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/candidato/dashboard");
    }
}
