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
public class EmploymentRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String Instutution;

    private String PositionExperience;
    private String yearstarted;
    private String yearEndede;

    @ManyToOne
    @JoinColumn(name = "applic" , nullable = false)
    private Applicant applic;

//    @ManyToOne
//    @JoinColumn(name = "applic" , nullable = false)
//    private SignUP applic;




}
