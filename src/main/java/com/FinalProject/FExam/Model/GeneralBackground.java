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
public class GeneralBackground {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String UniversityAtt;
    private String DateYouWantToStart;
    private String Major;
    private String ModeOfStudy;
    private String Language;
    private String Nameofreferees;

    @ManyToOne
    @JoinColumn(name = "applic" , nullable = false)
    private Applicant applic;

//    @ManyToOne
//    @JoinColumn(name = "applic" , nullable = false)
//    private SignUP applic;

}
