package com.FinalProject.FExam.Repository;

import com.FinalProject.FExam.Model.SignUP;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUPRepository extends JpaRepository<SignUP,Long> {

    SignUP findByEmail(String email);

}
