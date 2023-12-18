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

public class Applicant {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String familyName;
        private String firstName;
        private String otherName;
        private String presentMailingAddress;
        private String permanentMailingAddress;
        private String telephone;
        private String emailAddress;
        private String maritalStatus;
        private int numberOfChildren;
        private String gender;
        private String dateOfBirth;
        private String placeOfBirth;
        private String countryOfCitizenship;
        private String passportOrNationalId;
        private String countryOfResidence;
        private String typeOfVisa;
        private String religiousAffiliation;
        private String churchAddress;
        private boolean handicap;
        private String handicapDetails;

        @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
        private Set <GeneralBackground> General = new HashSet<>();

        @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
        private Set <EducationalBackground> Educational = new HashSet<>();

        @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
        private Set <EmploymentRecords> Employment = new HashSet<>();


        @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
        private Set <SuportingDocuments> suporting = new HashSet<>();


//        @ManyToOne
//        @JoinColumn(name = "applic" , nullable = false)
//        private SignUP applic;




        public enum EvaluationResult {
                ACCEPTED, REJECTED
        }

        @Enumerated(EnumType.STRING)
        private EvaluationResult evaluationResult;



    }



