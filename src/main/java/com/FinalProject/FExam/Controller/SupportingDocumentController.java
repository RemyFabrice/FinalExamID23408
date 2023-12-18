package com.FinalProject.FExam.Controller;

import com.FinalProject.FExam.Model.Applicant;
import com.FinalProject.FExam.Model.SuportingDocuments;
import com.FinalProject.FExam.Service.SupportingDocumentsService;
//import com.FinalProject.FYear.Model.JwtTokenUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@SessionAttributes("applicantId")

@Controller
public class SupportingDocumentController {

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private SupportingDocumentsService supportingDocumentsService;

    public SupportingDocumentController(SupportingDocumentsService supportingDocumentsService) {
        this.supportingDocumentsService = supportingDocumentsService;
    }

    @GetMapping("/saveSD")
    public String showSP(Model model) {
        model.addAttribute("suportingDocuments", new SuportingDocuments());
        return "SD";
    }

    @PostMapping("/saveSD")
    public String UploadFiles(@RequestParam("applicationReciept") MultipartFile applicationReciepts,
                              @RequestParam ("UniversityCertificate") MultipartFile universityCertificate,
                              @RequestParam( "seconadryCertificate") MultipartFile secondaryCertificate,
                              @RequestParam("photo") MultipartFile photo,
                              @RequestParam("universityTranscript") MultipartFile universityTranscript,
                              @RequestParam("refereesLetter1") MultipartFile  refereesLetter1,
                              @RequestParam("refereesLetter2") MultipartFile  refereesLetter2,
                              @RequestParam("refereesLetter3") MultipartFile  refereesLetter3,
                              @RequestParam( "upadatedCV") MultipartFile  upadatedCV,
                              @RequestParam("essay") MultipartFile essay,


                              @ModelAttribute("applicantId") Long applicantId , HttpSession session, HttpServletResponse response , Model model) throws IOException  {

        SuportingDocuments suportingDocuments = new SuportingDocuments();

        if (!applicationReciepts.isEmpty()){

                        String applicationRecieptsBase64 = Base64.getEncoder().encodeToString(applicationReciepts.getBytes());
                        suportingDocuments.setApplicationReceipt(applicationRecieptsBase64);
                    }

        if (!universityCertificate.isEmpty()) {
            String universityCertificateBase64 = Base64.getEncoder().encodeToString(universityCertificate.getBytes());
            suportingDocuments.setUniversityCertificate(universityCertificateBase64);
        }

        if (!secondaryCertificate.isEmpty()) {
            String secondaryCertificateBase64 = Base64.getEncoder().encodeToString(secondaryCertificate.getBytes());
            suportingDocuments.setSecondaryCertificate(secondaryCertificateBase64);
        }

        if (!photo.isEmpty()) {
            String photoBase64 = Base64.getEncoder().encodeToString(photo.getBytes());
            suportingDocuments.setPhoto(photoBase64);
        }

        if (!universityTranscript.isEmpty()){

            String universityTranscriptBase64 = Base64.getEncoder().encodeToString(universityTranscript.getBytes());

            suportingDocuments.setUniversityTranscript(universityTranscriptBase64);

        }

        if (!refereesLetter1.isEmpty()){

            String refereesLetter1Base64 = Base64.getEncoder().encodeToString(refereesLetter1.getBytes());

            suportingDocuments.setRefereesLetter1(refereesLetter1Base64);
        }


        if (!refereesLetter2.isEmpty()){

            String refereesLetter2Base64 = Base64.getEncoder().encodeToString(refereesLetter2.getBytes());

            suportingDocuments.setRefereesLetter2(refereesLetter2Base64);

        }

        if (!refereesLetter3.isEmpty()){

            String refereesLetter3Base64 = Base64.getEncoder().encodeToString(refereesLetter1.getBytes());

             suportingDocuments.setRefereesLetter3(refereesLetter3Base64);

        }

        if(!upadatedCV.isEmpty()){

            String upadatedCVBase64 = Base64.getEncoder().encodeToString(upadatedCV.getBytes());

            suportingDocuments.setUpdatedCV(upadatedCVBase64);

        }

        if (!essay.isEmpty()){

            String essayBase64 = Base64.getEncoder().encodeToString(essay.getBytes());

             suportingDocuments.setEssay(essayBase64);
        }
        Applicant applicant = new Applicant();
        applicant.setId(applicantId);
        suportingDocuments.setApplic(applicant);

        String temporaryId = UUID.randomUUID().toString();
        Cookie cookie = new Cookie("temporaryId", temporaryId);
        cookie.setMaxAge(3600); // Set the cookie to expire in 1 hour (adjust as needed)
        cookie.setPath("/"); // Set the cookie path appropriately
        response.addCookie(cookie);
        supportingDocumentsService.saveSuportingDocumts(suportingDocuments);
        model.addAttribute("message", "Files uploaded successfully.");
        return "redirect:/";
    }


    @GetMapping("/displayDocuments")

    public String ShowevaluationForm(Model model){


        List<SuportingDocuments> document = supportingDocumentsService.displaySuportingDocuments();

        model.addAttribute("document" , document);

        return "Evaluation-Form";
    }














}
