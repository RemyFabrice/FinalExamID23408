package com.FinalProject.FExam.Service;

import com.FinalProject.FExam.Model.RegisterEvaluation;
import com.FinalProject.FExam.Repository.EvaluationRepository;
import com.FinalProject.FExam.Repository.RegisterEvalutionRepository;
import com.FinalProject.FExam.Model.Evaluation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RegisterEvaluationService {


    private final RegisterEvalutionRepository registerEvalutionRepository;

    private final EvaluationRepository evaluationRepository;

    public RegisterEvaluationService(RegisterEvalutionRepository registerEvalutionRepository, EvaluationRepository evaluationRepository) {
        this.registerEvalutionRepository = registerEvalutionRepository;
        this.evaluationRepository = evaluationRepository;
    }

    public void saveEvalution(RegisterEvaluation registerEvaluation){

        registerEvalutionRepository.save(registerEvaluation);

    }

    public List<Evaluation> displayevaluation(){

        return evaluationRepository.findAll();

    }

    public Optional<Evaluation> displaybyId(Long id){

        return evaluationRepository.findById(id);
    }
}
