package com.FinalProject.FExam.Service;


import com.FinalProject.FExam.Repository.GeneralBackgroundRepository;
import com.FinalProject.FExam.Model.GeneralBackground;
import org.springframework.stereotype.Service;

@Service
public class GeneralBackgroundservice {

    private final GeneralBackgroundRepository generalBackgroundRepository;


    public GeneralBackgroundservice(GeneralBackgroundRepository generalBackgroundRepository) {
        this.generalBackgroundRepository = generalBackgroundRepository;
    }

    public void saveGB(GeneralBackground generalBackground){

        generalBackgroundRepository.save(generalBackground);

    }
}
