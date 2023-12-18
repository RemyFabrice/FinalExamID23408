package com.FinalProject.FExam.Repository;

import com.FinalProject.FExam.Model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
