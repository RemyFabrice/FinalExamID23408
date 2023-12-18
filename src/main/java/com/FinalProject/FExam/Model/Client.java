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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String familyName;
    private String firstName;
    private String Location;
    @OneToMany(mappedBy = "client" , cascade = CascadeType.REMOVE)
    private Set<Question> Question = new HashSet<>();
}
