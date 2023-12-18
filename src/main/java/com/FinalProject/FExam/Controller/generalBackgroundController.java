package com.FinalProject.FExam.Controller;


import com.FinalProject.FExam.Model.Applicant;
import com.FinalProject.FExam.Model.GeneralBackground;
import com.FinalProject.FExam.Service.GeneralBackgroundservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("applicantId")
@Controller
public class generalBackgroundController {

    @Autowired
    private GeneralBackgroundservice generalBackgroundservice;

    public generalBackgroundController(GeneralBackgroundservice generalBackgroundservice) {
        this.generalBackgroundservice = generalBackgroundservice;
    }

    @GetMapping("/saveGB")
    public String showGB(Model model) {
        model.addAttribute("generalBackground", new GeneralBackground());
        return "GB";
    }

    @PostMapping("/saveGB")
    public String saveGB(@ModelAttribute("generalBackground") GeneralBackground generalBackground, @ModelAttribute("applicantId") Long applicantId) {

        Applicant applicant = new Applicant();
        applicant.setId(applicantId);
        generalBackground.setApplic(applicant);

//        SignUP signUP = new SignUP();
//        signUP.setId(applicantId);
//        generalBackground.setApplic(signUP);


        generalBackgroundservice.saveGB(generalBackground);
        return "redirect:/saveEB";
    }

}
