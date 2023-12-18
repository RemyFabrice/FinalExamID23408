package com.FinalProject.FExam.Controller;

import com.FinalProject.FExam.Model.Question;
import com.FinalProject.FExam.Service.Questionservice;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class QuestionController {

    private Questionservice questionservice;
//    @GetMapping("/saveQE")
//    public String showApplicantForm(Model model) {
//        model.addAttribute("Client", new Question());
//        return "ClientAdd";
//    }


    @GetMapping("/ClientInformation")
    public String ShowhomeInformation(){


        return "ApplicantDashBoard";
    }

    @PostMapping("/saveQE")
    public String saveApplicant(@ModelAttribute("Question") Question question , Model model) {

        Question savedQuestion = questionservice.saveQuestion(question);



        questionservice.saveQuestion(question);
        return "redirect:/ClientInformation";
    }
}
