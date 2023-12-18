package com.FinalProject.FExam.Controller;

import com.FinalProject.FExam.Model.Applicant;
import com.FinalProject.FExam.Model.EmploymentRecords;
import com.FinalProject.FExam.Service.EmploymentRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("applicantId")
@Controller
public class EmploymentRecordController {
    @Autowired
    private EmploymentRecordsService employmentRecordsService;

    public EmploymentRecordController(EmploymentRecordsService employmentRecordsService) {
        this.employmentRecordsService = employmentRecordsService;
    }

    @GetMapping("/saveER")
     public String showER(Model model){

         model.addAttribute("employmentRecords", new EmploymentRecords());

         return "ER";

     }

    @PostMapping("/saveER")
    public String saveER(@ModelAttribute("employmentRecords") EmploymentRecords employmentRecords, @ModelAttribute("applicantId") Long applicantId){

        Applicant applicant = new Applicant();
        applicant.setId(applicantId);
        //employmentRecords.setApplic(applicant);
        employmentRecords.setApplic(applicant);

//        SignUP signUP = new SignUP();
//        signUP.setId(applicantId);
//        employmentRecords.setApplic(signUP);

        employmentRecordsService.savER(employmentRecords);

        return "redirect:/saveSD";

    }

}
