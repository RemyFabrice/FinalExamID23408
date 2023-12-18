package com.FinalProject.FExam.Controller;


import com.FinalProject.FExam.Model.Evaluation;
import com.FinalProject.FExam.Model.SuportingDocuments;
import com.FinalProject.FExam.Service.EvaluationService;
import com.FinalProject.FExam.Service.SupportingDocumentsService;
//import com.FinalProject.FYear.Model.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@SessionAttributes("applicantId")
@Controller
public class EvaluationController {


//    @Autowired
//    private PdfGenerator pdfGenerator;


//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private SupportingDocumentsService supportingDocumentsService;

    @GetMapping("/EvalutionDashboard")
    public String showDashbord(){

        return "EvaluationDashboard";

    }

    @GetMapping("/displayFiles")
    public String displayFiles(Model model){

        List<SuportingDocuments> document = supportingDocumentsService.displaySuportingDocuments();

        /* List<SuportingDocuments> documents = supportingDocumentsService.displaySuportingDocuments();*/
        model.addAttribute("document" , document);
        return "Evaluation-Form";
    }

  @GetMapping("/displayone")

  public String displaybyId(@RequestParam(name = "id") Long id ,Model model)  {
      Optional<SuportingDocuments> supportingDocuments = supportingDocumentsService.displayById(id);

      if (supportingDocuments.isPresent()){
         model.addAttribute("evaluation",new Evaluation());
          model.addAttribute("supportingDocuments" ,supportingDocuments.get());
          return "Display-one-SupportingDocuments";
      } else {

          model.addAttribute("message", "ApplicantFile not found with ID: " + id);
          return "error-page";
      }
  }

  @PostMapping("/submitEvaluation")

   public String SaveEvaluation(@ModelAttribute("evaluation")  Evaluation evaluation ) {
      try {
          SuportingDocuments sup=supportingDocumentsService.displayById(evaluation.getSupportingDocuments().getId()).orElse(null);
          Evaluation evaluationBySDoc=evaluationService.findBysupportingDocumentsId(sup);

//

          if(evaluationBySDoc==null)
          {
              evaluation.setSupportingDocuments(sup);
              Evaluation eval= evaluationService.SaveEvaluation(evaluation);
              System.out.println(eval+" Saved successfully");
          }
          else{

             evaluation.setId(evaluationBySDoc.getId());
              Evaluation eval= evaluationService.SaveEvaluation(evaluation);
          }
      } catch (Exception ex)
      {
          System.out.println(ex.getMessage());
      }
          return "redirect:/displayDocuments";
  }

//    @GetMapping("/downloadPdf")
//    public ResponseEntity<ByteArrayResource> downloadPdfReport(@RequestParam("admittedFilter") String admittedFilter) throws DocumentException {
//        List<Evaluation> evaluations = evaluationService.getAllEvaluations();
//
//        ByteArrayOutputStream pdfReport = pdfGenerator.generatePdfReport(evaluations, admittedFilter);
//
//        HttpHeaders headers = new HttpHeaders();
//        String filename = admittedFilter.equalsIgnoreCase("YES") ? "admitted_evaluation_report.pdf" : "non_admitted_evaluation_report.pdf";
//        headers.add("Content-Disposition", "attachment; filename=" + filename);
//
//        return ResponseEntity
//                .ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(new ByteArrayResource(pdfReport.toByteArray()));
//    }


}
