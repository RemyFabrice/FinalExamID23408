package com.FinalProject.FExam.Controller;


import com.FinalProject.FExam.Model.SignUP;
import com.FinalProject.FExam.Service.SignUpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

//import javax.validation.Valid;



@SessionAttributes("applicantId")
@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("signup", new SignUP());
        return "SignUp";
    }

    @PostMapping("/signup")
    private String SaveSignUp(@ModelAttribute("signup") SignUP signUP) {

        signUP.setRole("AdMember");

        signUpService.SaveSignUp(signUP);

        return "redirect:/signup";
    }

    @GetMapping("/LogIn")
    public String LoginForm(Model model) {
//        model.addAttribute("signup", new SignUP());
        return "LogIn";
    }

    @PostMapping("/LogIn")
    public String processLogin(@ModelAttribute("LogIn") SignUP signUP, Model model, HttpSession session) {

        SignUP user = signUpService.findByEmail(signUP.getEmail());

        SignUP savedSignUp = signUpService.SaveSignUp(signUP);

//        if (user != null) {
//
//            {
//                System.out.println("User found with email: " + user.getEmail());
//                System.out.println("User role: " + user.getRole());
//
//                //     session.setAttribute("loggedInUser", user);
//
//                if (user.getUserPassWord().equals(signUP.getUserPassWord())) {
//                    if ("Applicant".equals(user.getRole())) {
//
//                        model.addAttribute("applicantId", savedSignUp.getId());
//
//                        signUpService.SaveSignUp(signUP);
//                        return "redirect:saveApplicant";
//                    } else if ("AdMember".equals(user.getRole())) {
//
//                        model.addAttribute("applicantId", savedSignUp.getId());
//
//                        signUpService.SaveSignUp(signUP);
//                        return "redirect:EvaluationDashboard";
//                    } else if ("Register".equals(user.getRole())) {
//
//                        model.addAttribute("applicantId", savedSignUp.getId());
//
//                        signUpService.SaveSignUp(signUP);
//                        return "redirect:viewApplicDoc";
//                    }
//                }
//            }
//            // Existing logic for successful login
//        } else {
//
//            System.out.println("Login failed!");
//            model.addAttribute("error", "Invalid username or password");
//            return "redirect:/login";
//
//        }


        if (user != null) {
            System.out.println("User found with email: " + user.getEmail());
            System.out.println("User role: " + user.getRole());

            if (user.getUserPassWord().equals(signUP.getUserPassWord())) {
                if ("Applicant".equals(user.getRole())) {

                    model.addAttribute("applicantId",savedSignUp.getId());

                    signUpService.SaveSignUp(signUP);
                    return "redirect:saveApplicant";
                } else if ("AdMember".equals(user.getRole())) {

                    model.addAttribute("applicantId",savedSignUp.getId());

                    signUpService.SaveSignUp(signUP);

                    return "redirect:displayFiles";

//                    return "redirect:EvaluationDashboard";

                } else if ("Register".equals(user.getRole())) {

                    model.addAttribute("applicantId",savedSignUp.getId());

                    signUpService.SaveSignUp(signUP);

                    return "redirect:viewApplicDoc";

//                    return "redirect:Register DashBoard";
                }
            }
        }

        System.out.println("Login failed!");
        model.addAttribute("error", "Invalid username or password");
        return "redirect:/login";
//        model.addAttribute("error", "User not found");
//        return "redirect:/login";

    }
}











