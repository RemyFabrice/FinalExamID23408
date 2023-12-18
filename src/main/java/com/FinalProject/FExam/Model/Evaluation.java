package com.FinalProject.FExam.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Evaluation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String  ApplicantDocId;

    private String  applicationReceipt;  /* applicationReceipt */

    private String universityCertificate;

    private String  secondaryCertificate;

    private String  photo;

    private String  universityTranscript;

    private String  refereesLetter1;

    private String  refereesLetter2;

    private String  refereesLetter3;

    private String updatedCV;

    private String essay;

    private String Overalremarks;

  //  private String Admitted;




    @ManyToOne
    @JoinColumn(name = "supportingDocuments", nullable = false)
    private SuportingDocuments supportingDocuments;


    @OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL)
    private Set<Admision> admision = new HashSet<>();


//    @ManyToOne
//    @JoinColumn(name = "applic1" , nullable = false)
//    private SignUP applic1;
//
//    @ManyToOne
//    @JoinColumn(name = "applic" , nullable = false)
//    private SignUP applic;



}
