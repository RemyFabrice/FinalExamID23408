package com.FinalProject.FExam.Service;

import com.FinalProject.FExam.Repository.EmploymentRecordsRepository;
import com.FinalProject.FExam.Model.EmploymentRecords;
import org.springframework.stereotype.Service;

@Service
public class EmploymentRecordsService {

    private final EmploymentRecordsRepository employmentRecordsRepository;

    public EmploymentRecordsService(EmploymentRecordsRepository employmentRecordsRepository) {
        this.employmentRecordsRepository = employmentRecordsRepository;
    }

      public void savER(EmploymentRecords employmentRecords){

        employmentRecordsRepository.save(employmentRecords);

      }
}
