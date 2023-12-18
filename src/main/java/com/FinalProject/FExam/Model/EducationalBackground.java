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
public class EducationalBackground {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Secondary;

    private String SCountry;
    private String Syearstarted;
     private String SyearEndede;

    private String university;

    private String uCountry;
    private String uyearstarted;
    private String uyearEndede;
    @ManyToOne
    @JoinColumn(name = "applic" , nullable = false)
    private Applicant applic;

//    @ManyToOne
//    @JoinColumn(name = "applic" , nullable = false)
//    private SignUP applic;

//    @ManyToOne
//    @JoinColumn(name = "applic" , nullable = false)
//    private SignUP applic;
}
