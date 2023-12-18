package com.FinalProject.FExam.Service;

import com.FinalProject.FExam.Repository.EducationalBackgroundrepository;
import com.FinalProject.FExam.Model.EducationalBackground;
import org.springframework.stereotype.Service;


@Service
public class EducationalBackgroundService {

    private final EducationalBackgroundrepository educationalBackgroundrepository;


    public EducationalBackgroundService(EducationalBackgroundrepository educationalBackgroundrepository) {
        this.educationalBackgroundrepository = educationalBackgroundrepository;
    }

    public void saveEB(EducationalBackground educationalBackground){

        educationalBackgroundrepository.save(educationalBackground);
    }
}
