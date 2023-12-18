package com.FinalProject.FExam.Service;

import com.FinalProject.FExam.Repository.QuestionRepository;
import com.FinalProject.FExam.Model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Questionservice {


    private final QuestionRepository questionRepository;

    public Questionservice(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public List<Question> displayQuestion(){

        return questionRepository.findAll();

    }

    public Question saveQuestion(Question question){

        Question savedQuestion = questionRepository.save(question);


        return savedQuestion;


    }
}
