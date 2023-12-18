package com.FinalProject.FExam.Service;

import com.FinalProject.FExam.Repository.EvaluationRepository;
import com.FinalProject.FExam.Repository.SuportingDocumentsRepository;
import com.FinalProject.FExam.Model.SuportingDocuments;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportingDocumentsService {

    private final SuportingDocumentsRepository suportingDocumentsRepository;

    private final EvaluationRepository evaluationRepository;

    public SupportingDocumentsService(SuportingDocumentsRepository suportingDocumentsRepository, EvaluationRepository evaluationRepository) {
        this.suportingDocumentsRepository = suportingDocumentsRepository;
        this.evaluationRepository = evaluationRepository;
    }


     public SuportingDocuments saveSuportingDocumts(SuportingDocuments suportingDocuments){

        return suportingDocumentsRepository.save(suportingDocuments);

     }

    public List<SuportingDocuments> displaySuportingDocuments(){

        return suportingDocumentsRepository.findAll();

    }

    public Optional<SuportingDocuments> findByTemporaryId(String temporaryId) {
        return suportingDocumentsRepository.findByTemporaryId(temporaryId);
    }

    public Optional<SuportingDocuments> displayById( Long id){

        return suportingDocumentsRepository.findById(id);

    }

//    public Optional<Evaluation> findb


  //  Optional<SuportingDocuments> findByTemporaryId(String temporaryId);

}


