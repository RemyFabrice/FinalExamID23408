package com.FinalProject.FExam.Controller;


import com.FinalProject.FExam.Model.*;
import com.FinalProject.FExam.Service.*;
import com.FinalProject.FYear.Model.*;
import com.FinalProject.FYear.Service.*;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import com.FinalProject.FExam.Model.PdfGenerator;

//@SessionAttributes("applicantId")
@Controller
public class RegisterEvaluationController {


        @Autowired
    private PdfGenerator pdfGenerator;
    @Autowired
    private ApplicantService applicantService;


    @Autowired
    private SupportingDocumentsService supportingDocumentsService;

    @Autowired
    private RegisterEvaluationService registerEvaluationService;

    @Autowired
    private AdmisionService admisionService;

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/viewApplicDoc")

    public String displayEvaluations(Model model) {
        model.addAttribute("evaluations", registerEvaluationService.displayevaluation());
        return "Register-view-applicDoc";
    }

//    public String displayAdmision(Model model) {
//
//       List<Admision> admisions = admisionService.getAllAdmision();
//        model.addAttribute("Admision", admisions);
//        return "RegisterAdmision";
//    }


    @GetMapping("/Display-One")

    public String Displayoneevaluation(@RequestParam(name = "id") Long id , Model model){

        Optional<Evaluation> evaluation = evaluationService.ShowById(id);

        if(evaluation.isPresent()){
            model.addAttribute("evaluation", evaluation.get());

            return "Display-one-Evaluation";

        }
        else {

            model.addAttribute("message", "ApplicantFile not found with ID: " + id);
            return "error-page";
        }

    }

    @PostMapping("/submitAdmission")
    public String SaveAdmision(@ModelAttribute("admision") Admision admision  /*,  @ModelAttribute("applicantId") Long applicantId*/){

          try{

              Evaluation eval=evaluationService.ShowById(admision.getEvaluation().getId()).orElse(null);
              Admision admision1BySDoc=admisionService.findByEvaluationId(eval);

//              SignUP signUP = new SignUP();
//              signUP.setId(applicantId);
//              admision.setApplic2(signUP);

              if (admision1BySDoc==null)
              {
                  admision.setEvaluation(eval);
                  Admision savedAdmision = admisionService.saveADmision(admision);

                  System.out.println(savedAdmision + " Saved successfully");
              }

              else {

                  admision.setId(admision1BySDoc.getId());
                  Admision adm = admisionService.saveADmision(admision);

                  System.out.println(adm + " Saved successfully");
              }


          }catch (Exception ex){

              System.out.println(ex.getMessage());

          }
        return "redirect:/viewApplicDoc";
    }


        @GetMapping("/downloadPdf")
    public ResponseEntity<ByteArrayResource> downloadPdfReport(@RequestParam("admittedFilter") String admittedFilter) throws DocumentException {
        List<Admision> admisions = admisionService.getAllAdmision();

        ByteArrayOutputStream pdfReport = pdfGenerator.generatePdfReport(admisions, admittedFilter);

        HttpHeaders headers = new HttpHeaders();
        String filename = admittedFilter.equalsIgnoreCase("YES") ? "admitted_evaluation_report.pdf" : "non_admitted_evaluation_report.pdf";
        headers.add("Content-Disposition", "attachment; filename=" + filename);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new ByteArrayResource(pdfReport.toByteArray()));
    }





    @GetMapping("/DisplayUser")
    public String showUser(Model model) {
        List<SignUP> users = signUpService.getAllUser(); // Replace with your service method to fetch users
        model.addAttribute("users", users);
        return "DisplayUsers";

    }




}
