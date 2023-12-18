package com.FinalProject.FExam.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class USERS {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // or another suitable generation strategy
    private Long id;

}
