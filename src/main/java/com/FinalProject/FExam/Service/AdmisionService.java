package com.FinalProject.FExam.Service;


import com.FinalProject.FExam.Repository.AdmisionRepository;
import com.FinalProject.FExam.Repository.EvaluationRepository;
import com.FinalProject.FExam.Model.Admision;
import com.FinalProject.FExam.Model.Evaluation;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmisionService {

    private final JavaMailSender javaMailSender;

    private final AdmisionRepository admisionRepository;

    private final EvaluationRepository evaluationRepository;

    public AdmisionService(JavaMailSender javaMailSender, AdmisionRepository admisionRepository, EvaluationRepository evaluationRepository) {
        this.javaMailSender = javaMailSender;
        this.admisionRepository = admisionRepository;
        this.evaluationRepository = evaluationRepository;
    }

    public List<Admision> getAllAdmision(){

        return admisionRepository.findAll();
    }

    public Optional<Admision> ShowById(Long id){


        return admisionRepository.findById(id);
    }


//    public Evaluation findBysupportingDocumentsId(SuportingDocuments support)
//    {
//        return  evaluationRepository.findBySupportingDocuments(support);
//    }

    public Admision findByEvaluationId(Evaluation evaluation){

        return admisionRepository.findByEvaluation(evaluation);
    }





    public Admision saveADmision(Admision admision){

        Admision savedAdmision = admisionRepository.save(admision);

              try {
        if ("YES".equalsIgnoreCase(savedAdmision.getAdmitted())) {
            sendAdmittedEmail(savedAdmision);
        } else {
            sendNonAdmittedEmail(savedAdmision);
        }
        } catch (Exception ex) {
            // Handle the exception (e.g., log it) without interrupting the evaluation saving process.
            ex.printStackTrace();
        }



        return savedAdmision;
    }





    private void sendAdmittedEmail(Admision admision) {
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(admision.getEvaluation().getSupportingDocuments().getApplic().getEmailAddress());
        message.setTo(admision.getEvaluation().getSupportingDocuments().getApplic().getEmailAddress());
        message.setSubject("Congratulations! You've Been Admitted");
      //  message.setText("Dear " + admision.getEvaluation().getSupportingDocuments().getApplic().getFirstName() + ",\n\nCongratulations! You have been admitted to our program. We look forward to having you on board.");
          message.setText("Dear " + admision.getEvaluation().getSupportingDocuments().getApplic().getFirstName() + ",\n\nCongratulations! You have been admitted to our program. We look forward to having you on board.");
        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    private void sendNonAdmittedEmail(Admision admision) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(admision.getEvaluation().getSupportingDocuments().getApplic().getEmailAddress());
        //  message.setTo(evaluation.getEmail());
        message.setSubject("Application Status Update");
        message.setText("Dear " +  admision.getEvaluation().getSupportingDocuments().getApplic().getFirstName()  + ",\n\nWe regret to inform you that your application has not been admitted at this time. We appreciate your interest and encourage you to consider applying again in the future.");

        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }




}
