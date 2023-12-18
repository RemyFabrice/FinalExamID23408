package com.FinalProject.FExam.Repository;

import com.FinalProject.FExam.Model.Admision;
import com.FinalProject.FExam.Model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmisionRepository extends JpaRepository<Admision,Long> {

    Admision findByEvaluation(Evaluation evaluation);
}
