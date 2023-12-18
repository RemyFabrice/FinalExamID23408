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
public class SignUP  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String email;
    private String userPassWord;

    @Transient
    private String confirmPassword;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Applicant'")
    private String Role;

//    @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
//    private Set <Applicant> General = new HashSet<>();

//    @OneToMany(mappedBy = "applic1" , cascade = CascadeType.REMOVE)
//    private Set<Evaluation> General1 = new HashSet<>();

//    @OneToMany(mappedBy = "applic2" , cascade = CascadeType.REMOVE)
//    private Set <Admision> General2 = new HashSet<>();

//    @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
//    private Set <EducationalBackground> educational = new HashSet<>();
//
//    @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
//    private Set <GeneralBackground> GB = new HashSet<>();
//
//    @OneToMany(mappedBy = "applic" , cascade = CascadeType.REMOVE)
//    private Set <SuportingDocuments> SD = new HashSet<>();




}
