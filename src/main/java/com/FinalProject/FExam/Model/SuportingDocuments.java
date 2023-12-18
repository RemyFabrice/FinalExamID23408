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

public class SuportingDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

  // private int evaluationCount;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String  applicationReceipt;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String universityCertificate;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String  secondaryCertificate;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String  photo;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String  universityTranscript;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String  refereesLetter1;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String  refereesLetter2;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String  refereesLetter3;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String updatedCV;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String essay;

    private String status;

    @Column(name = "temporary_id")
    private String temporaryId;



    @ManyToOne
    @JoinColumn(name = "applic" , nullable = false)
    private Applicant applic;



    @OneToMany(mappedBy = "supportingDocuments", cascade = CascadeType.ALL)
    private Set<Evaluation> evaluations = new HashSet<>();






}
