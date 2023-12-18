package com.FinalProject.FExam.Model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Staff {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or another suitable generation strategy
    private Long id;

    private String Email;
    private String Password;



}
