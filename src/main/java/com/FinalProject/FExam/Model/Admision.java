package com.FinalProject.FExam.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Admision {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    private String EvaluatioID;

    private String Admitted;


    @ManyToOne
    @JoinColumn(name = "evaluation", nullable = false)
    private Evaluation evaluation;

//    @ManyToOne
//    @JoinColumn(name = "applic2" , nullable = false)
//    private SignUP applic2;
}
