package com.FinalProject.FExam.Service;


import com.FinalProject.FExam.Repository.SignUPRepository;
import com.FinalProject.FExam.Model.SignUP;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService {


    private final SignUPRepository signUPRepository;

    public SignUpService(SignUPRepository signUPRepository) {
        this.signUPRepository = signUPRepository;
    }
    public SignUP findByEmail(String email) {

       return signUPRepository.findByEmail(email);

    }

    public List<SignUP> getAllUser() {
        return signUPRepository.findAll();
    }

    public SignUP SaveSignUp(SignUP signUP){

        SignUP savedSignup = signUPRepository.save(signUP);

        return savedSignup;

    }

}
