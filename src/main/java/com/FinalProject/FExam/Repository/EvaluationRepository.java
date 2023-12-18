package com.FinalProject.FExam.Repository;

import com.FinalProject.FExam.Model.Evaluation;
import com.FinalProject.FExam.Model.SuportingDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation , Long> {
    Evaluation findBySupportingDocuments(SuportingDocuments support);
}
