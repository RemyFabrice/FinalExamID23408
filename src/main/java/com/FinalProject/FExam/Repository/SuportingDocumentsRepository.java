package com.FinalProject.FExam.Repository;

import com.FinalProject.FExam.Model.SuportingDocuments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuportingDocumentsRepository extends JpaRepository<SuportingDocuments , Long> {

    Optional<SuportingDocuments> findByTemporaryId(String temporaryId);
}
