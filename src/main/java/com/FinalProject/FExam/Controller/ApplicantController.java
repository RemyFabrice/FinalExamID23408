package com.FinalProject.FExam.Controller;


import com.FinalProject.FExam.Model.Applicant;
import com.FinalProject.FExam.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("applicantId")
public class ApplicantController {
    @Autowired
    private ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/saveApplicant")
    public String showApplicantForm(Model model) {
        model.addAttribute("applicant", new Applicant());
        return "ApplicantSave";
    }


    @PostMapping("/saveApplicant")
    public String saveApplicant(@ModelAttribute("applicant") Applicant applicant ,Model model) {

        Applicant savedapplicant = applicantService.saveApplicant(applicant);

        model.addAttribute("applicantId",savedapplicant.getId());

        applicantService.saveApplicant(applicant);
        return "redirect:/saveGB";
    }
    @GetMapping("/applicants")
    public String showApplicantList(Model model) {
        model.addAttribute("applicantlist", applicantService.getAllApplicant());
        return "applicantlist";
    }






}
