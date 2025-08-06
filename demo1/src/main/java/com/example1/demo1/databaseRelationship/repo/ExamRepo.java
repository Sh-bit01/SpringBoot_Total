package com.example1.demo1.databaseRelationship.repo;

import com.example1.demo1.databaseRelationship.model.ExamDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepo extends JpaRepository<ExamDetails, Long> {
}
