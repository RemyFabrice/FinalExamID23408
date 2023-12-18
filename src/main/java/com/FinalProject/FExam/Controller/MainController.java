package com.FinalProject.FExam.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String ShowhomePage(){


        return "HOME";
    }

    @GetMapping("/ApplicantHome")
    public String ShowhomeApplicantDashboard(){


        return "ApplicantDashBoard";
    }

    @GetMapping("/RegisterHome")
    public String ShowhomeRegisterDashboard(){


        return "Register DashBoard";
    }

    @GetMapping("/AdMemberHome")
    public String ShowhomeADmemberDashboard(){


        return "EvaluationDashboard";
    }


}
