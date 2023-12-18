package com.FinalProject.FExam.Service;


import com.FinalProject.FExam.Repository.ApplicantRepository;
import com.FinalProject.FExam.Model.Applicant;
import jakarta.transaction.Transactional;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final JavaMailSender javaMailSender;


    private final ApplicantRepository applicantRepository;


    public ApplicantService(JavaMailSender javaMailSender, ApplicantRepository applicantRepository) {
        this.javaMailSender = javaMailSender;
        this.applicantRepository = applicantRepository;
    }


    @Transactional
     public Applicant saveApplicant(Applicant applicant){

        Applicant savedApplicant = applicantRepository.save(applicant);


         sendEmail(savedApplicant);

         return savedApplicant;


     }

    public List<Applicant> getAllApplicant() {
        return applicantRepository.findAll();
    }


        private void sendEmail(Applicant applicant) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(applicant.getEmailAddress());
        message.setSubject("Application Confirmation");
        message.setText("Dear " + applicant.getFirstName() + ",\n\nYour application has been received You will be notified for further Upadte.");

        try {
            javaMailSender.send(message);
        } catch (MailException e) {

            e.printStackTrace();
        }
    }




}
