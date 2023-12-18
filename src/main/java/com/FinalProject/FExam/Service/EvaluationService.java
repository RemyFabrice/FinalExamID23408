package com.FinalProject.FExam.Service;

import com.FinalProject.FExam.Model.SuportingDocuments;
import com.FinalProject.FExam.Repository.EvaluationRepository;
import com.FinalProject.FExam.Repository.SuportingDocumentsRepository;
import com.FinalProject.FExam.Model.Evaluation;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluationService {



    private final JavaMailSender javaMailSender;
    public int count;

   @Autowired
   private final EvaluationRepository evaluationRepository;

    private final SuportingDocumentsRepository suportingDocumentsRepository;

    public EvaluationService(JavaMailSender javaMailSender, EvaluationRepository evaluationRepository, SuportingDocumentsRepository suportingDocumentsRepository) {
        this.javaMailSender = javaMailSender;
        this.evaluationRepository = evaluationRepository;
        this.suportingDocumentsRepository = suportingDocumentsRepository;
    }


    @Transactional
    public Evaluation SaveEvaluation(Evaluation evaluation){
     //System.out.println(evaluation.getRefereesLetter3());

        Evaluation savedEvaluation = evaluationRepository.save(evaluation);

//        try {
//        if ("YES".equalsIgnoreCase(savedEvaluation.getAdmitted())) {
//            sendAdmittedEmail(savedEvaluation);
//        } else {
//            sendNonAdmittedEmail(savedEvaluation);
//        }
//        } catch (Exception ex) {
//            // Handle the exception (e.g., log it) without interrupting the evaluation saving process.
//            ex.printStackTrace();
//        }
//        sendEmail(savedApplicant);

        return savedEvaluation;

    }





public  Evaluation findBysupportingDocumentsId(SuportingDocuments support)
{
    return  evaluationRepository.findBySupportingDocuments(support);
}




public List<Evaluation> getAllEvaluations(){

        return evaluationRepository.findAll();
}







    public List<SuportingDocuments> showSuportingDocuments(){

       return suportingDocumentsRepository.findAll();

    }

    public Optional <Evaluation> ShowById(Long id){


        return evaluationRepository.findById(id);
    }


//    public Optional<SuportingDocuments> displayById( Long id){
//
//        return suportingDocumentsRepository.findById(id);
//
//    }



    private void sendAdmittedEmail(Evaluation evaluation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(evaluation.getSupportingDocuments().getApplic().getEmailAddress());
        message.setSubject("Congratulations! You've Been Admitted");
        message.setText("Dear " + evaluation.getSupportingDocuments().getApplic().getFirstName() + ",\n\nCongratulations! You have been admitted to our program. We look forward to having you on board.");

        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    private void sendNonAdmittedEmail(Evaluation evaluation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(evaluation.getSupportingDocuments().getApplic().getEmailAddress());
      //  message.setTo(evaluation.getEmail());
        message.setSubject("Application Status Update");
        message.setText("Dear " +  evaluation.getSupportingDocuments().getApplic().getFirstName()  + ",\n\nWe regret to inform you that your application has not been admitted at this time. We appreciate your interest and encourage you to consider applying again in the future.");

        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }







}
