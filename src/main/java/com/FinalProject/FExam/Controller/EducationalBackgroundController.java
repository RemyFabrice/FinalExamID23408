package com.FinalProject.FExam.Controller;

import com.FinalProject.FExam.Model.Applicant;
import com.FinalProject.FExam.Model.EducationalBackground;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.FinalProject.FExam.Service.EducationalBackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("applicantId")
@Controller
public class EducationalBackgroundController {
   @Autowired
     public EducationalBackgroundService educationalBackgroundService;

    public EducationalBackgroundController(EducationalBackgroundService educationalBackgroundService) {
        this.educationalBackgroundService = educationalBackgroundService;
    }

    @GetMapping("/saveEB")
     public String showEB(Model model){

         model.addAttribute("educationalBackground", new EducationalBackground());

          return"EB";
     }

     @PostMapping("/saveEB")
    public String saveEB(@ModelAttribute("educationalBackground") EducationalBackground educationalBackground, @ModelAttribute("applicantId") Long applicantId){

         Applicant applicant = new Applicant();
         applicant.setId(applicantId);
         educationalBackground.setApplic(applicant);

//         SignUP signUP = new SignUP();
//         signUP.setId(applicantId);
//         educationalBackground.setApplic(signUP);

        educationalBackgroundService.saveEB(educationalBackground);


         return "redirect:/saveER";

    }

}
