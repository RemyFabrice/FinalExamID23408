package com.FinalProject.FExam.Repository;

import com.FinalProject.FExam.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client , Long> {
}
